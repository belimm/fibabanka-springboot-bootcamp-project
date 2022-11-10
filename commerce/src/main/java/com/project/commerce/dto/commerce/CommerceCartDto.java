package com.project.commerce.dto.commerce;

import java.util.List;

public class CommerceCartDto {
    private Long cartId;
    private String customerName;
    private List<CommerceCartProductDto> cartProducts;

    public CommerceCartDto() {}

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

    public List<CommerceCartProductDto> getCartProducts() {
        return cartProducts;
    }

    public void setCartProducts(List<CommerceCartProductDto> cartProducts) {
        this.cartProducts = cartProducts;
    }

    @Override
    public String toString() {
        return "CommerceCartDto{" +
                "cartId=" + cartId +
                ", customerName='" + customerName + '\'' +
                ", cartProducts=" + cartProducts +
                '}';
    }
}
