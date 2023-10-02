package br.com.mentorama.LojaOnline_OrderSalesOperation.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "TB_productstocks")
public class ProductStock {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idProduct;

    private String nameProduct;

    private int quantityStock;

    private Double priceProduct;

    private Double maxDiscountPercentage;

    public ProductStock(UUID idProduct, String nameProduct, int quantityStock,
                        Double priceProduct, Double maxDiscountPercentage) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.quantityStock = quantityStock;
        this.priceProduct = priceProduct;
        this.maxDiscountPercentage = maxDiscountPercentage;
    }

    public ProductStock (UUID idProduct, int quantityStock){
        this.idProduct = idProduct;
        this.quantityStock = quantityStock;
    }

    public ProductStock() {
    }

    public void increaseQuantity (int quantity){
        this.quantityStock += quantity;
    }

    public UUID getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(UUID idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public int getQuantityStock() {
        return quantityStock;
    }

    public void setQuantityStock(int quantityStock) {
        this.quantityStock = quantityStock;
    }

    public Double getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(Double priceProduct) {
        this.priceProduct = priceProduct;
    }

    public Double getMaxDiscountPercentage() {
        return maxDiscountPercentage;
    }

    public void setMaxDiscountPercentage(Double maxDiscountPercentage) {
        this.maxDiscountPercentage = maxDiscountPercentage;
    }
}
