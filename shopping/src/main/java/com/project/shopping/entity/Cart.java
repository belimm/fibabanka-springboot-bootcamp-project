package com.project.shopping.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.List;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "cartId")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;
    private String customerName;
    private Double totalAmount;
    private Integer cartStatus;

    @OneToMany(mappedBy = "cart",
            cascade = CascadeType.ALL,
            orphanRemoval=true,
            fetch = FetchType.EAGER)
    private List<CartProduct> cartProducts;

    public Cart() {
        this.totalAmount=0D;
        this.cartStatus=0;
    }

    public Cart(String customerName) {
        this.customerName = customerName;
        this.totalAmount=0D;
        this.cartStatus=0;
    }

    public Cart(String customerName, Double totalAmount) {
        this.customerName = customerName;
        this.totalAmount = totalAmount;
        this.cartStatus = 0;
    }

    public Cart(Long cartId, String customerName, Double totalAmount) {
        this.cartId = cartId;
        this.customerName = customerName;
        this.totalAmount = totalAmount;
        this.cartStatus = 0;
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

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Integer getCartStatus() {
        return cartStatus;
    }

    public void setCartStatus(Integer cartStatus) {
        this.cartStatus = cartStatus;
    }

    public List<CartProduct> getCartProducts() {
        return cartProducts;
    }

    public void setCartProducts(List<CartProduct> cartProducts) {
        this.cartProducts = cartProducts;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartId=" + cartId +
                ", customerName='" + customerName + '\'' +
                ", totalAmount=" + totalAmount +
                ", cartStatus=" + cartStatus +
                '}';
    }
}
