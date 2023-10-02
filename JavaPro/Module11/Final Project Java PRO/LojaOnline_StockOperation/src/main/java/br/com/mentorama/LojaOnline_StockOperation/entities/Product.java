package br.com.mentorama.LojaOnline_StockOperation.entities;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "TB_products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID codeProduct;

    private String nameProduct;

    private BigDecimal price;

    private Double maxDiscountPercentage;

    public Product() {
    }

    public Product(UUID codeProduct, String nameProduct, BigDecimal price, Double maxDiscountPercentage) {
        this.codeProduct = codeProduct;
        this.nameProduct = nameProduct;
        this.price = price;
        this.maxDiscountPercentage = maxDiscountPercentage;
    }

    public UUID getCodeProduct() {
        return codeProduct;
    }

    public void setCodeProduct(UUID codeProduct) {
        this.codeProduct = codeProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Double getMaxDiscountPercentage() {
        return maxDiscountPercentage;
    }

    public void setMaxDiscountPercentage(Double maxDiscountPercentage) {
        this.maxDiscountPercentage = maxDiscountPercentage;
    }
}
