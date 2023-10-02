package br.com.mentorama.LojaOnline_OrderSalesOperation.controllers;

import br.com.mentorama.LojaOnline_OrderSalesOperation.entities.*;
import br.com.mentorama.LojaOnline_OrderSalesOperation.services.CustomerService;
import br.com.mentorama.LojaOnline_OrderSalesOperation.services.OrderItemService;
import br.com.mentorama.LojaOnline_OrderSalesOperation.services.OrderService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderItemService orderItemService;

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public ResponseEntity<Order> create(@RequestBody Order newOrder) throws ClassNotFoundException {

        System.out.println("Order Foi Chamada na Controller");

        if (newOrder.getIdCustomer() != null) {
            Order createdOrder = orderService.save(newOrder);
            return new ResponseEntity<>(createdOrder, HttpStatus.CREATED);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                "Cliente Não Encontrado");
    }
}
