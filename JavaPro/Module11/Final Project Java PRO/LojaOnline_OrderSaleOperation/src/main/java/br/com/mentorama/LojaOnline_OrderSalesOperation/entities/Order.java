package br.com.mentorama.LojaOnline_OrderSalesOperation.entities;

import br.com.mentorama.LojaOnline_OrderSalesOperation.entities.enums.PaymentMethod;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "TB_orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idOrder;

    private UUID idCustomer;

    private Integer idUser;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
    private List<OrderItem> items;

    private String dateOrderEntry;

    private Double discountOrder;

    private Double totalPriceOrder;

    private PaymentMethod paymentMethod;

    public Order(){};

    public Order(UUID idOrder, UUID idCustomer, Integer idUser,
                 List<OrderItem> items, String dateOrderEntry,
                 Double discountOrder, Double totalPriceOrder,
                 PaymentMethod paymentMethod) {
        this.idOrder = idOrder;
        this.idCustomer = idCustomer;
        this.idUser = idUser;
        this.items = items;
        this.dateOrderEntry = dateOrderEntry;
        this.discountOrder = discountOrder;
        this.totalPriceOrder = totalPriceOrder;
        this.paymentMethod = paymentMethod;
    }

    public UUID getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(UUID idOrder) {
        this.idOrder = idOrder;
    }

    public UUID getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(UUID idCustomer) {
        this.idCustomer = idCustomer;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    public String getDateOrderEntry() {
        return dateOrderEntry;
    }

    public void setDateOrderEntry(String dateOrderEntry) {
        this.dateOrderEntry = dateOrderEntry;
    }

    public Double getDiscountOrder() {
        return discountOrder;
    }

    public void setDiscountOrder(Double discountOrder) {
        this.discountOrder = discountOrder;
    }

    public Double getTotalPriceOrder() {
        return totalPriceOrder;
    }

    public void setTotalPriceOrder(Double totalPriceOrder) {
        this.totalPriceOrder = totalPriceOrder;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
