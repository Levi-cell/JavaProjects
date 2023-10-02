package com.spring.products.Service;

import com.spring.products.Models.OrderItem;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderCalculateTest {
    @Test
    public void calculatesThePriceOfAList(){
        final OrderCalculate orderCalculator = new OrderCalculate();
        final List<OrderItem> orderItems = Arrays.asList(
                assertOrderItem(20.0),
                assertOrderItem(100.0)
        );
        Double result = orderCalculator.CalculateOrder(orderItems);
        assertEquals(120,result);
    }

    private OrderItem assertOrderItem(final Double expectedValue){
        OrderItem orderItem = Mockito.mock(OrderItem.class);
        Mockito.when(orderItem
                .totalPrice()).thenReturn(expectedValue);
        return orderItem;
    }
}