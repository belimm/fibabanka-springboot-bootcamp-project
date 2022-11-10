package com.project.shopping.service;

import com.project.shopping.dto.CartProductDto;
import com.project.shopping.dto.ProductDto;
import com.project.shopping.entity.Cart;
import com.project.shopping.entity.CartProduct;
import com.project.shopping.repository.CartProductRepository;
import com.project.shopping.repository.CartRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class CartProductService implements ICartProductService{
    private final CartProductRepository cartProductRepository;
    private final CartRepository cartRepository;
    private final RestTemplate restTemplate;

    public CartProductService(CartProductRepository cartProductRepository, CartRepository cartRepository, RestTemplate restTemplate) {
        this.cartProductRepository = cartProductRepository;
        this.cartRepository = cartRepository;
        this.restTemplate = restTemplate;
    }

    @Override
    public ResponseEntity<?> addCartProduct(CartProductDto cartProductDto) {

        if(cartProductDto.getProductId() == null ||
                cartProductDto.getSalesQuantity() == null ||
                cartProductDto.getCartId() == null
        ){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Please enter productId && salesQuantity && cardId && cardProductId");
        }

        CartProduct cartProduct = toEntity(cartProductDto);

        if(cartProduct.getCart() == null) {
            return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(String.format("There is no Cart with ID %s",cartProductDto.getCartId()));
        }

        System.out.println(getProductPriceFromProductId(cartProductDto.getProductId()));

        Cart cart = cartRepository.findById(cartProduct.getCart().getCartId()).orElse(null);
        cart.setTotalAmount(cart.getTotalAmount()+cartProduct.getLineAmount());

        cartRepository.save(cart);

        CartProduct newCartProduct = cartProductRepository.save(cartProduct);

        System.out.println(newCartProduct);
        return ResponseEntity
            .ok()
            .body(toDto(newCartProduct));
    }

    private Double getProductPriceFromProductId(Long productId) {
        String uri = String.format("http://localhost:8081/inventory/product/%s",productId);

        try{
            ProductDto productDto = restTemplate.getForObject(uri, ProductDto.class);
            return productDto.getSalesPrice();
        }
        catch (Error error){
            System.out.println("Something went wrong!");
        }

        return 0D;
    }

    public CartProduct toEntity(CartProductDto cartProductDto){
        CartProduct cartProduct = new CartProduct();

        cartProduct.setCartProductId(cartProductDto.getCartProductId());
        cartProduct.setProductId(cartProductDto.getProductId());
        cartProduct.setSalesPrice(getProductPriceFromProductId(cartProductDto.getProductId()));
        cartProduct.setSalesQuantity(cartProductDto.getSalesQuantity());

        cartProduct.setLineAmount(cartProduct.getSalesPrice()*cartProductDto.getSalesQuantity());
        System.out.println(cartProduct);

        cartProduct.setCart(cartRepository.findById(cartProductDto.getCartId()).orElse(null));

        return cartProduct;
    }

    public CartProductDto toDto(CartProduct cartProduct){
        CartProductDto cartProductDto = new CartProductDto();

        cartProductDto.setCartId(cartProduct.getCart().getCartId());
        cartProductDto.setCartProductId(cartProduct.getCartProductId());
        cartProductDto.setProductId(cartProduct.getProductId());
        cartProductDto.setSalesPrice(cartProduct.getSalesPrice());
        cartProductDto.setSalesQuantity(cartProduct.getSalesQuantity());
        cartProductDto.setLineAmount(cartProduct.getLineAmount());


        return cartProductDto;
    }
}

