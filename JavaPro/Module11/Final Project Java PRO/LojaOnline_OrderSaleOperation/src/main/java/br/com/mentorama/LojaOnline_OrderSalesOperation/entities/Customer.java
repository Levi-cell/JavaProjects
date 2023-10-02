package br.com.mentorama.LojaOnline_OrderSalesOperation.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "TB_customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idCustomer;

    @Column(nullable = false)
    private String nameCustomer;

    @Column(nullable = false , unique = true)
    private String emailCustomer;

    @Column(nullable = false , unique = true)
    private String passwordCustomer;

    public Customer(UUID idCustomer, String nameCustomer, String emailCustomer, String passwordCustomer) {
        this.idCustomer = idCustomer;
        this.nameCustomer = nameCustomer;
        this.emailCustomer = emailCustomer;
        this.passwordCustomer = passwordCustomer;
    }

    public Customer(){}

    public UUID getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(UUID idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public String getEmailCustomer() {
        return emailCustomer;
    }

    public void setEmailCustomer(String emailCustomer) {
        this.emailCustomer = emailCustomer;
    }

    public String getPasswordCustomer() {
        return passwordCustomer;
    }

    public void setPasswordCustomer(String passwordCustomer) {
        this.passwordCustomer = passwordCustomer;
    }
}
