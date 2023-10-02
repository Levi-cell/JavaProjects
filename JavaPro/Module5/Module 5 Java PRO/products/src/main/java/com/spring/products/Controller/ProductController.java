package com.spring.products.Controller;

import com.spring.products.Models.Product;
import com.spring.products.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductRepository productRepository;

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping
    public Product addList(@RequestBody Product newProduct){

        return productRepository.save(newProduct);
    }


    @GetMapping()
    public List<Product> findAllList(){
        return (ArrayList<Product>) productRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public Product findById(@PathVariable  Integer id){
        Optional<Product> product = productRepository.findById(id);
        if(product.isPresent()){
            return product.get();
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto Não encontrado");
        }
    }



}
