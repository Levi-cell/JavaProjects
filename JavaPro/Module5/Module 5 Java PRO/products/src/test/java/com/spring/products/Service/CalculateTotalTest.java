package com.spring.products.Service;

import com.spring.products.Models.Product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculateTotalTest {
    @Test
    public void calculateTotalTest() {

        Product product = new Product(2L, "Celular", 1000.00, 10, 0.10);
        Product product2 = new Product(3L, "Notebook", 4000.00, 10, 0.10);
        Product product3 = new Product(4L, "Geladeira", 3000.00, 10, 0.10);

        Double valueOne = CalculateTotal.shouldCalculateTotalPriceProducts(product, 0.0, 3);

        assertEquals(3000.0, valueOne);

        Double valueTwo = CalculateTotal.shouldCalculateTotalPriceProducts(product2,0.0,2);
        assertEquals(8000,valueTwo);

        Double valueThree = CalculateTotal.shouldCalculateTotalPriceProducts(product3, 0.0,3);
        assertEquals(9000.0,valueThree);

        System.out.println(valueOne + valueTwo + valueThree);

        Double priceTotal = CalculateTotal.totalPriceSaleProduct(valueOne,valueTwo,valueThree);
        assertEquals(20000.0, priceTotal);
    }
}