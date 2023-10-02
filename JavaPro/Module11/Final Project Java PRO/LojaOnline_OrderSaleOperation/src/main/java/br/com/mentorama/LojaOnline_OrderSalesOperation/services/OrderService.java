package br.com.mentorama.LojaOnline_OrderSalesOperation.services;

import br.com.mentorama.LojaOnline_OrderSalesOperation.entities.Customer;
import br.com.mentorama.LojaOnline_OrderSalesOperation.entities.Order;
import br.com.mentorama.LojaOnline_OrderSalesOperation.entities.OrderItem;
import br.com.mentorama.LojaOnline_OrderSalesOperation.entities.ProductStock;
import br.com.mentorama.LojaOnline_OrderSalesOperation.repositories.CustomerRepository;
import br.com.mentorama.LojaOnline_OrderSalesOperation.repositories.OrderItemRepository;
import br.com.mentorama.LojaOnline_OrderSalesOperation.repositories.OrderRepository;
import br.com.mentorama.LojaOnline_OrderSalesOperation.repositories.ProductStockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderItemRepository orderItemRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ProductStockRepository productStockRepository;

    @Autowired
    OrderItemService orderItemService;

    public OrderService (OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    public Order save (Order order) throws ClassNotFoundException {

       Customer customer = customerRepository.findById(order.getIdCustomer()).orElseThrow();
            if (!customerRepository.existsById(order.getIdCustomer())) {
                throw new ClassNotFoundException("Cliente Não Encontrado !");
            } else {

                order.setIdCustomer(customer.getIdCustomer());

                // Apenas para confirmar o acesso a CustomerRepository
                System.out.println(customer.getNameCustomer());

                System.out.println("OrderItem foi chamada em OrderService");

                Iterator<OrderItem> oi = order.getItems().iterator();

                while (oi.hasNext()){
                    OrderItem orderItem = oi.next();
                    ProductStock product = productStockRepository.findById
                                           (orderItem.getIdProductStock()).orElseThrow();
                    if (orderItemService.availableQuantityVerification( orderItem.getIdProductStock(),
                        orderItem.getQuantityItem())) {
                        product.setQuantityStock(product.getQuantityStock() - orderItem.getQuantityItem());

                        if (order.getDiscountOrder() <= product.getMaxDiscountPercentage()) {
                            orderItem.setTotalPriceItem(product.getPriceProduct() * orderItem.getQuantityItem());
                        } else {
                            throw new ClassNotFoundException("Desconto Acima do Permitido !");
                        }
                        orderItem.setOrder(order);
                        orderItem.setIdProductStock(orderItem.getIdProductStock());
                        order.setTotalPriceOrder(order.getTotalPriceOrder() + orderItem.getTotalPriceItem());
                        orderItemService.updateProductStockByOrderItem(orderItem, product);

                        } else {
                        oi.remove();
                        throw new ClassNotFoundException("Produto Não Disponível no Estoque!");
                        }
                    }
                if (!order.getItems().isEmpty()){
                    orderRepository.save(order);
                }
            return order;
        }
    }

    public Order update (Order order) throws ClassNotFoundException{

        Order ord = orderRepository.findById(order.getIdOrder()).orElseThrow();
        if (!orderRepository.existsById(order.getIdOrder())) {
            throw new ClassNotFoundException("Pedido de Venda Não Encontrado !");
        } else {
            orderRepository.save(order);
        }
        return order;
    }

    public List<Order> findAll(){

        return orderRepository.findAll();
    }

    public Order findById(UUID orderId){

        return orderRepository.findById(orderId).orElseThrow();
    }
}
