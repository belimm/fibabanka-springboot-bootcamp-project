package com.project.commerce.dto.commerce;

public class CommerceCartProductDto {
    private Long cartProductId;
    private Long cartId;
    private Long productId;
    private String productName;
    private Double salesPrice;
    private Integer salesQuantity;
    private Double lineAmount;
    public CommerceCartProductDto() {}

    public Long getCartProductId() {
        return cartProductId;
    }

    public void setCartProductId(Long cartProductId) {
        this.cartProductId = cartProductId;
    }

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(Double salesPrice) {
        this.salesPrice = salesPrice;
    }

    public Integer getSalesQuantity() {
        return salesQuantity;
    }

    public void setSalesQuantity(Integer salesQuantity) {
        this.salesQuantity = salesQuantity;
    }

    public Double getLineAmount() {
        return lineAmount;
    }

    public void setLineAmount(Double lineAmount) {
        this.lineAmount = lineAmount;
    }

    @Override
    public String toString() {
        return "CommerceDto{" +
                "cartProductId=" + cartProductId +
                ", cartId=" + cartId +
                ", productId=" + productId +
                ", productName='" + productName + '\'' +
                ", salesPrice=" + salesPrice +
                ", salesQuantity=" + salesQuantity +
                ", lineAmount=" + lineAmount +
                '}';
    }
}
