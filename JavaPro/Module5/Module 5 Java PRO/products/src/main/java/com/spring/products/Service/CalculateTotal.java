package com.spring.products.Service;

import com.spring.products.Models.Product;

public class CalculateTotal {
    public static double shouldCalculateTotalPriceProducts(Product product, Double discount, Integer quantity){
        Double productSale = product.getDiscountPrice(discount);
        Integer productSale1= product.getQuantityOfProductAvailable(quantity);
        return  productSale * productSale1;
    }
    public static double totalPriceSaleProduct(Double product, Double productTwo, Double productThree){
        return product + productTwo + productThree;
    }
}
