package br.com.mentorama.LojaOnline_OrderSalesOperation.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table (name = "TB_orderitens")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idOrderItem;


    @ManyToOne
    @JoinColumn(name = "id_order")
    @JsonIgnore
    private Order order;

    private UUID idProductStock;

    private int quantityItem;

    private Double totalPriceItem;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public OrderItem() {
    }

    public OrderItem(Integer idOrderItem, Order order, UUID idProductStock,
                     int quantityItem, Double totalPriceItem) {
        this.idOrderItem = idOrderItem;
        this.order = order;
        this.idProductStock = idProductStock;
        this.quantityItem = quantityItem;
        this.totalPriceItem = totalPriceItem;
    }

    public Integer getIdOrderItem() {
        return idOrderItem;
    }

    public void setIdOrderItem(Integer idOrderItem) {
        this.idOrderItem = idOrderItem;
    }

    public UUID getIdProductStock() {
        return idProductStock;
    }

    public void setIdProductStock(UUID idProductStock) {
        this.idProductStock = idProductStock;
    }

    public int getQuantityItem() {
        return quantityItem;
    }

    public void setQuantityItem(int quantityItem) {
        this.quantityItem = quantityItem;
    }

    public Double getTotalPriceItem() {
        return totalPriceItem;
    }

    public void setTotalPriceItem(Double totalPriceItem) {
        this.totalPriceItem = totalPriceItem;
    }
}

