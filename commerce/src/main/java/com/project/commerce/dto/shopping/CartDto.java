package com.project.commerce.dto.shopping;


import java.util.List;

public class CartDto {
    private Long cartId;
    private String customerName;
    private List<CartProductDto> cartProducts;

    public CartDto() {}

    public CartDto(Long cartId, String customerName, List<CartProductDto> cartProducts) {
        this.cartId = cartId;
        this.customerName = customerName;
        this.cartProducts = cartProducts;
    }
    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public List<CartProductDto> getCartProducts() {
        return cartProducts;
    }

    public void setCartProducts(List<CartProductDto> cartProducts) {
        this.cartProducts = cartProducts;
    }

    @Override
    public String toString() {
        return "CartDto{" +
                "cartId=" + cartId +
                ", customerName='" + customerName + '\'' +
                ", cartProducts=" + cartProducts +
                '}';
    }
}
