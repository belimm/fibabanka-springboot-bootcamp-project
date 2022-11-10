package com.project.commerce.dto.shopping;

public class CartProductDto {
    private Long cartProductId;
    private Long cartId;
    private Long productId;
    private Double salesPrice;
    private Integer salesQuantity;

    private Double lineAmount;

    public CartProductDto() {}

    public CartProductDto(Long cartProductId, Long cartId, Long productId, Double salesPrice, Integer salesQuantity, Double lineAmount) {
        this.cartProductId = cartProductId;
        this.cartId = cartId;
        this.productId = productId;
        this.salesPrice = salesPrice;
        this.salesQuantity = salesQuantity;
        this.lineAmount = lineAmount;
    }

    public Long getCartProductId() {
        return cartProductId;
    }

    public void setCartProductId(Long cartProductId) {
        this.cartProductId = cartProductId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getSalesQuantity() {
        return salesQuantity;
    }

    public void setSalesQuantity(Integer salesQuantity) {
        this.salesQuantity = salesQuantity;
    }

    public Double getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(Double salesPrice) {
        this.salesPrice = salesPrice;
    }

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public Double getLineAmount() {
        return lineAmount;
    }

    public void setLineAmount(Double lineAmount) {
        this.lineAmount = lineAmount;
    }

    @Override
    public String toString() {
        return "CartProductDto{" +
                "cartProductId=" + cartProductId +
                ", cartId=" + cartId +
                ", productId=" + productId +
                ", salesPrice=" + salesPrice +
                ", salesQuantity=" + salesQuantity +
                ", lineAmount=" + lineAmount +
                '}';
    }
}
