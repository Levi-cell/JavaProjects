package br.com.mentorama.LojaOnline_OrderSalesOperation.services;

import br.com.mentorama.LojaOnline_OrderSalesOperation.entities.OrderItem;
import br.com.mentorama.LojaOnline_OrderSalesOperation.entities.ProductStock;
import br.com.mentorama.LojaOnline_OrderSalesOperation.repositories.OrderItemRepository;
import br.com.mentorama.LojaOnline_OrderSalesOperation.repositories.ProductStockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderItemService {

    @Autowired
    OrderItemRepository orderItemRepository;

    @Autowired
    ProductStockRepository productStockRepository;

    public boolean availableQuantityVerification (UUID idProduct, int quantity){

        ProductStock productStock = productStockRepository.findById(idProduct).orElseThrow();
        if (productStockRepository.existsById(idProduct)){
            if(quantity <= productStock.getQuantityStock() && quantity>0){
                return true;
            }
        }
        return false;
    }

    public void updateProductStockByOrderItem(OrderItem orderItem, ProductStock productStock){
        ProductStock stock = new ProductStock(orderItem.getIdProductStock(),
                                             productStock.getQuantityStock());
        productStockRepository.save(stock);
    }
}
