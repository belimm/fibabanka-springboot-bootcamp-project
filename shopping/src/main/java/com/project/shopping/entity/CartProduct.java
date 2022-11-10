package com.project.shopping.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "cartProductId")
public class CartProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartProductId;
    private Long productId;
    private Integer salesQuantity;
    private Double salesPrice;
    private Double lineAmount;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cart_id")
    private Cart cart;

    public CartProduct() {
    }

    public CartProduct(Long productId, Integer salesQuantity, Double salesPrice, Double lineAmount) {
        this.productId = productId;
        this.salesQuantity = salesQuantity;
        this.salesPrice = salesPrice;
        this.lineAmount = lineAmount;
    }

    public CartProduct(Long cartProductId, Long productId, Integer salesQuantity, Double salesPrice, Double lineAmount) {
        this.cartProductId = cartProductId;
        this.productId = productId;
        this.salesQuantity = salesQuantity;
        this.salesPrice = salesPrice;
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

    public Double getLineAmount() {
        return lineAmount;
    }

    public void setLineAmount(Double lineAmount) {
        this.lineAmount = lineAmount;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    @Override
    public String toString() {
        return "CartProduct{" +
                "cartProductId=" + cartProductId +
                ", productId=" + productId +
                ", salesQuantity=" + salesQuantity +
                ", salesPrice=" + salesPrice +
                ", lineAmount=" + lineAmount +
                ", cart=" + cart +
                '}';
    }
}
