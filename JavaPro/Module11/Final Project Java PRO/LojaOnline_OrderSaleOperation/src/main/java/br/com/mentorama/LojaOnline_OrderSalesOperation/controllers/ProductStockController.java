package br.com.mentorama.LojaOnline_OrderSalesOperation.controllers;

import br.com.mentorama.LojaOnline_OrderSalesOperation.entities.ProductStock;
import br.com.mentorama.LojaOnline_OrderSalesOperation.exceptions.ProduckStockExistException;
import br.com.mentorama.LojaOnline_OrderSalesOperation.services.ProductStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/productStock")
public class ProductStockController {

    @Autowired
    private ProductStockService productStockService;

    @PostMapping
    public ResponseEntity<ProductStock> create(@RequestBody ProductStock newProductStock) {
        try {
            ProductStock createdProductStock = productStockService.save(newProductStock);
            return new ResponseEntity<>(createdProductStock, HttpStatus.CREATED);
        } catch (ProduckStockExistException exception) {
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @PatchMapping ("increase/{id}")
    public ResponseEntity<ProductStock> increaseQuantity(@PathVariable UUID idStockProduct,
                                                         @RequestBody ProductStock productStock){
        ProductStock updateQuantityOfProductStock = productStockService
                                                    .increaseQuantityOfProductStock(productStock);
        return new ResponseEntity<>(updateQuantityOfProductStock, HttpStatus.OK);
    }

    @GetMapping("/{idProductStock}")
    public ResponseEntity<ProductStock> findById(@PathVariable("idProductStock") UUID idProductStock){
            return new ResponseEntity<>(productStockService.findById(idProductStock), HttpStatus.OK);
    }

   @GetMapping
   public ResponseEntity<List<ProductStock>> findAll(){
            return  new ResponseEntity<>(productStockService.findAll(), HttpStatus.OK);
   }
}
