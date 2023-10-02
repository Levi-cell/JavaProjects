package com.spring.products.Models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    @Test
    public void calculateTotalPricesOfDiscounts(){
        Product product = new Product(2L,"Celular",100.00,10, 0.10);
        Double result = product.getDiscountPrice(0.10);
        assertEquals(90,result);
    }

    @Test
    public void calculateTotalPricesOfDiscountshigh(){
        Product product = new Product(3L,"Celular",100.00,10, 0.10);
        Double result = product.getDiscountPrice(0.15);
        assertEquals(90,result);
    }

    @Test
    public void calculateTotalPricesOfDiscountslower(){
        Product product = new Product(4L,"Celular",100.00,10, 0.10);
        Double result = product.getDiscountPrice(0.05);
        assertEquals(95,result);
    }
    @Test
    public void quantityProductOfSaleInStock(){
        Product product = new Product(5L,"Celular",100.00,10, 0.10);
        Integer result = product.getQuantityOfProductAvailable(3);
        assertEquals(3, result);
    }
}