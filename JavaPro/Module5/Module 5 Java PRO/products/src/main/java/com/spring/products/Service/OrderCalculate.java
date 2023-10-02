package com.spring.products.Service;

import com.spring.products.Models.OrderItem;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderCalculate {
    public Double CalculateOrder(final List<OrderItem> items){
        return items.stream().mapToDouble(OrderItem::totalPrice).sum();
    }
}
