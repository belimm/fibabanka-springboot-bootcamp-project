package com.project.commerce.service;

import com.project.commerce.dto.commerce.CommerceCartDto;
import com.project.commerce.dto.shopping.CartDto;
import com.project.commerce.dto.shopping.CartProductDto;
import com.project.commerce.dto.commerce.CommerceCartProductDto;
import com.project.commerce.dto.inventory.ProductDto;
import org.springframework.http.*;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ShoppingService {
    private final RestTemplate restTemplate;

    public ShoppingService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<?> createCart(String customerName) {
        String uri ="http://localhost:8082/shopping/cart/create";
        HttpHeaders headers = new HttpHeaders();
        headers.set("Customer-Name",customerName);
        HttpEntity<String> entity = new HttpEntity<>("paramters",headers);


        ResponseEntity<Integer> cartId = restTemplate.exchange(
                uri,
                HttpMethod.GET,
                entity,
                Integer.class
        );

        return ResponseEntity
            .ok()
            .body(cartId.getBody());
    }

    public ResponseEntity<?> addCartProduct(CartProductDto cartProductDto) {
        String uri = "http://localhost:8082/shopping/cart/add";

        try {
            CartProductDto response = restTemplate.postForObject(uri,cartProductDto,CartProductDto.class);

            return ResponseEntity
                    .ok()
                    .body(toCommerceDto(response));
        }
        catch (HttpMessageNotReadableException er){ //In case of empty fields
            return ResponseEntity
                    .ok()
                    .body("Empty fields!");
        }
    }

    public ResponseEntity<?> removeCartProductFromCartByProductId(Long cartId, Long productId) {
        if(cartId<=0 || productId<=0) {
            return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("Invalid ID!");
        }

        String uri = String.format("http://localhost:8082/shopping/cart/%s/remove/%s",cartId,productId);

        try{
            restTemplate.delete(uri);

            return ResponseEntity
                    .ok()
                    .body("Successfully removed");
        }
        catch (HttpClientErrorException error){ //In case of invalid cartId or productId
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Please enter a valid cartId or productId");
        }

    }

    public ResponseEntity<?> checkOutByCartId(Long cartId) {
        String uri= String.format("http://localhost:8082/shopping/checkout/%s",cartId);

        try {
            CartDto cartDto = restTemplate.getForObject(uri,CartDto.class);

            CommerceCartDto commerceCartDto = toCommerceCartDto(cartDto);
            List<CommerceCartProductDto> commerceCartProductDtoList = new ArrayList<>();

            for(CartProductDto c:cartDto.getCartProducts()){
                System.out.println(c);
                CommerceCartProductDto commerceCartProductDto = toCommerceCartProductDto(c);
                commerceCartProductDto.setProductName(getProductNameFromInventory(commerceCartProductDto.getProductId()));
                commerceCartProductDtoList.add(commerceCartProductDto);
            }

            commerceCartDto.setCartProducts(commerceCartProductDtoList);

            return ResponseEntity
                    .ok()
                    .body(commerceCartDto);
        }
        catch (HttpClientErrorException e){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(String.format("The Cart with ID %s does not exist!",cartId));
        }

    }

    public ResponseEntity<?> findCart(Long cartId) {
        if(cartId<=0) { //In case of invalid cartId
            return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("Invalid ID!");
        }

        String uri = String.format("http://localhost:8082/shopping/cart/find?cartId=%s",cartId);

        try {
            CartDto cartDto = restTemplate.getForObject(uri,CartDto.class);
            CommerceCartDto commerceCartDto = toCommerceCartDto(cartDto);
            List<CommerceCartProductDto> commerceCartProductDtoList = new ArrayList<>();

            for(CartProductDto c:cartDto.getCartProducts()){
                System.out.println(c);
                CommerceCartProductDto commerceCartProductDto = toCommerceCartProductDto(c);
                commerceCartProductDto.setProductName(getProductNameFromInventory(commerceCartProductDto.getProductId()));
                commerceCartProductDtoList.add(commerceCartProductDto);
            }

            commerceCartDto.setCartProducts(commerceCartProductDtoList);
            return ResponseEntity
                    .ok()
                    .body(commerceCartDto);
        }
        catch (HttpClientErrorException e){ //In case of cart with given id does not exist in the DB!
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(String.format("The Cart with ID %s does not exist!",cartId));
        }

    }

    private CommerceCartProductDto toCommerceDto(CartProductDto cartProductDto){
        CommerceCartProductDto commerceDto = new CommerceCartProductDto();
        commerceDto.setCartId(cartProductDto.getCartId());
        commerceDto.setCartProductId(cartProductDto.getCartProductId());
        commerceDto.setProductId(cartProductDto.getProductId());
        commerceDto.setProductName(getProductNameFromInventory(cartProductDto.getProductId()));
        commerceDto.setSalesPrice(cartProductDto.getSalesPrice());
        commerceDto.setSalesQuantity(cartProductDto.getSalesQuantity());
        commerceDto.setLineAmount(cartProductDto.getLineAmount());

        return commerceDto;
    }

    private CommerceCartDto toCommerceCartDto(CartDto cartDto){
        CommerceCartDto commerceCartDto = new CommerceCartDto();
        commerceCartDto.setCartId(cartDto.getCartId());
        commerceCartDto.setCustomerName(cartDto.getCustomerName());

        return commerceCartDto;
    }

    private CommerceCartProductDto toCommerceCartProductDto(CartProductDto cartProductDto){
        CommerceCartProductDto commerceCartProductDto = new CommerceCartProductDto();
        commerceCartProductDto.setCartId(cartProductDto.getCartId());
        commerceCartProductDto.setCartProductId(cartProductDto.getCartProductId());
        commerceCartProductDto.setProductId(cartProductDto.getProductId());
        commerceCartProductDto.setProductName("");
        commerceCartProductDto.setLineAmount(cartProductDto.getLineAmount());
        commerceCartProductDto.setSalesPrice(cartProductDto.getSalesPrice());
        commerceCartProductDto.setSalesQuantity(cartProductDto.getSalesQuantity());

        return commerceCartProductDto;
    }

    private String getProductNameFromInventory(Long productId){
        String uri = String.format("http://localhost:8081/inventory/product/%s",productId);

        Optional<ProductDto> productDto = Optional.ofNullable(restTemplate.getForObject(uri, ProductDto.class));

        return productDto.map(ProductDto::getProductName).orElse(null);
    }
}
