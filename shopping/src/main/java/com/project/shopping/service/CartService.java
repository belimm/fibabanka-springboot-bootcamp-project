package com.project.shopping.service;

import com.project.shopping.dto.CartDto;
import com.project.shopping.dto.CartProductDto;
import com.project.shopping.entity.Cart;
import com.project.shopping.entity.CartProduct;
import com.project.shopping.repository.CartRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartService implements ICartService{
    private final CartRepository cartRepository;

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    public ResponseEntity<?> createCart(String customerName) {
        if(customerName==null || customerName.equals("")) { //If customerName is empty
            return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("Please add customer name as header like 'Customer-Name:your-name'");
        }

        Cart cart = new Cart();
        cart.setCustomerName(customerName);

        Cart newCart = cartRepository.save(cart);

        return ResponseEntity
                .ok()
                .body(newCart.getCartId());
    }

    @Override
    public ResponseEntity<?> removeCartProductFromCartByProductId(Long cartId, Long productId) {
        if(cartId<=0 || productId<=0) { //In case of invalid cartId or productId
            return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("Invalid ID(s)!");
        }


        Cart cart = cartRepository.findById(cartId).orElse(null);
        if(cart==null) { //If there is no cart with given id
            return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(String.format("There is no cart with ID %s",cartId));
        }

        int foundedIndex = 0 ;
        boolean founded = false;

        for(CartProduct c: cart.getCartProducts()){
            if(c.getProductId() == productId){ //In case of match
                founded=true;
                break;
            }
            foundedIndex++;
        }

        if(!founded){
            return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(String.format("There is no product with ID %s in the cart with ID %s",productId,cartId));
        }

        cart.getCartProducts().remove(foundedIndex); //Remove CartProduct element with foundedIndex

        cartRepository.save(cart); //To update DB

        return ResponseEntity
            .ok()
            .body("Succesfuly removed");
    }

    @Override
    public ResponseEntity<?> checkOutByCartId(Long cartId) {
        Cart cart = cartRepository.findById(cartId).orElse(null);

        if(cart == null){ //If there is no Cart with given cartId
            return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(String.format("There is no cart with ID %s",cartId));
        }

        cart.setCartStatus(1); //Change status of the cart
        Cart newCart = cartRepository.save(cart);


        return ResponseEntity
            .ok()
            .body(toCartDto(newCart));
    }


    @Override
    public ResponseEntity<?> findCart(Long cartId) {
        if(cartId<=0) { //In case of invalid ID
            return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("Invalid ID!");
        }

        Optional<Cart> cart = cartRepository.findById(cartId);

        if(cart.isEmpty()) { // If there is no Cart with given cartId
            return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(String.format("There is no Cart with ID %s",cartId));
        }

       CartDto cartDto = toCartDto(cart.get()); //DTO conversion

        return ResponseEntity
            .ok()
            .body(cartDto);
    }

    /**
     * It takes as Cart and maps into CartDto
     * @param cart
     */
    public CartDto toCartDto(Cart cart){
        CartDto cartDto = new CartDto();

        cartDto.setCartId(cart.getCartId());
        cartDto.setCustomerName(cart.getCustomerName());

        List<CartProductDto> cartProductDtoList = new ArrayList<>();

        for(CartProduct cp:cart.getCartProducts()){
            cartProductDtoList.add(toCardProductDto(cp));
        }

        cartDto.setCartProducts(cartProductDtoList);


        return cartDto;
    }

    /**
     * It takes as CartProduct and maps into CartProductDto
     * @param cartProduct
     */
    public CartProductDto toCardProductDto(CartProduct cartProduct){
        CartProductDto cartProductDto = new CartProductDto();
        cartProductDto.setProductId(cartProduct.getProductId());
        cartProductDto.setCartProductId(cartProduct.getCartProductId());
        cartProductDto.setSalesPrice(cartProduct.getSalesPrice());
        cartProductDto.setSalesQuantity(cartProduct.getSalesQuantity());
        cartProductDto.setCartId(cartProduct.getCart().getCartId());
        cartProductDto.setLineAmount(cartProduct.getLineAmount());

        return cartProductDto;
    }
}
