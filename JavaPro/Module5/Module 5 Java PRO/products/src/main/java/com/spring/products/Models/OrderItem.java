package com.spring.products.Models;

public class OrderItem {
    private Product product;
    private Integer quantity;
    private Double discount;

    public OrderItem(Product product, Integer quantity, Double discount) {
        this.product = product;
        this.quantity = quantity;
        this.discount = discount;
    }

    public Double totalPrice(){
        return product.getDiscountPrice(discount) * quantity;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }
}
