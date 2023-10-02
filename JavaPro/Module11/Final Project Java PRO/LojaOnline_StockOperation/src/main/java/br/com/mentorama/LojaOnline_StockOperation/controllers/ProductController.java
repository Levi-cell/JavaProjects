package br.com.mentorama.LojaOnline_StockOperation.controllers;

import br.com.mentorama.LojaOnline_StockOperation.entities.Product;
import br.com.mentorama.LojaOnline_StockOperation.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@RestController
@RequestMapping ("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody Product newProduct){
        Product product = productService.save(newProduct);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    @GetMapping("/{codeProduct}")
    public ResponseEntity<Product> findById(@PathVariable("codeProduct") UUID codeProduct){
        return new ResponseEntity<>(productService.findById(codeProduct), HttpStatus.OK);
    }

    @GetMapping("/find")
    public ResponseEntity <List<Product>> findByNameProduct(@RequestParam("nameProduct") String nameProduct){

            List<Product> products = productService.findByNameProduct(nameProduct);
            if(products.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(products, HttpStatus.OK);
   }

    @GetMapping
    public ResponseEntity<List<Product>> findAll(){
        return  new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
    }
}
