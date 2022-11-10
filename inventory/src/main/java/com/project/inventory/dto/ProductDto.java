package com.project.inventory.dto;


public class ProductDto {
    private Long productId;
    private String productName;
    private Long categoryId;
    private String categoryName;
    private Double salesPrice;

    public ProductDto() {}

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

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "ProductDto{" +
                "productId=" + productId +
                ", categoryId=" + categoryId +
                ", productName='" + productName + '\'' +
                ", categoryName='" + categoryName + '\'' +
                ", salesPrice=" + salesPrice +
                '}';
    }
}
