package br.com.mentorama.LojaOnline_StockOperation.controllers;


import br.com.mentorama.LojaOnline_StockOperation.entities.Product;
import br.com.mentorama.LojaOnline_StockOperation.entities.Stock;
import br.com.mentorama.LojaOnline_StockOperation.services.ProductService;
import br.com.mentorama.LojaOnline_StockOperation.services.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping ("/stock")

public class StockController {

    @Autowired
    private StockService stockService;

    @PostMapping ("/{codeProduct}")
    public ResponseEntity<Stock> create(@RequestBody Stock newStock,
                                        @PathVariable ("codeProduct") UUID codeProduct) {
        newStock.setCodeProduct(codeProduct);
        Stock stock = stockService.saveStock(newStock);
        return new ResponseEntity<>(stock, HttpStatus.CREATED);
    }

    @PatchMapping("/{codeProduct}")
    public ResponseEntity<Stock> purchaseForStock(@RequestBody Stock stock,
                                                  @PathVariable ("codeProduct") UUID codeProduct){
        Stock stc = stockService.findStockByIdProduct(codeProduct);
        stock.setCodeProduct(codeProduct);
        stock.setAvailableQuantity(stc.getAvailableQuantity() + stock.getQuantity());
        stockService.saveStock(stock);
        return new ResponseEntity<>(stock, HttpStatus.OK);
    }

    @GetMapping("/{codeProduct}")
    public ResponseEntity<Stock> findStockByCodeProduct(@PathVariable("codeProduct") UUID codeProduct){
        return new ResponseEntity<>(stockService.findStockByIdProduct(codeProduct), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Stock>> findAll(){
        return  new ResponseEntity<>(stockService.findAll(), HttpStatus.OK);
    }
}
