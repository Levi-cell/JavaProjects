package br.com.mentorama.LojaOnline_StockOperation.entities;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "TB_stocks")
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID stockId;

    private UUID codeProduct;

    private int quantity;

    private int availableQuantity;

    public Stock() {
    }

    public Stock(UUID codeProduct, int quantity, int availableQuantity) {
        this.codeProduct = codeProduct;
        this.quantity = quantity;
        this.availableQuantity = availableQuantity;
    }

    public UUID getStockId() {
        return stockId;
    }

    public void setStockId(UUID stockId) {
        this.stockId = stockId;
    }

    public UUID getCodeProduct() {
        return codeProduct;
    }

    public void setCodeProduct(UUID codeProduct) {
        this.codeProduct = codeProduct;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public int getAvailableQuantity(){
        return availableQuantity;
    }

    public void setAvailableQuantity(int availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

}