package br.com.mentorama.LojaOnline_StockOperation.services;

import br.com.mentorama.LojaOnline_StockOperation.entities.Product;
import br.com.mentorama.LojaOnline_StockOperation.repositories.ProductRepository;
import org.aspectj.bridge.IMessageHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import javax.xml.crypto.dsig.spec.ExcC14NParameterSpec;
import java.util.*;

@Service
public class ProductService {

    private Product product;

    @Autowired
    private ProductRepository productRepository;

    public Product save(Product product){

        return productRepository.save(product);
    }

    public List<Product> findByNameProduct(String nameProduct) {

        return productRepository.findByNameProduct(nameProduct);
    }

    public Product findById(UUID codeProduct) {

        return productRepository.findById(codeProduct).orElseThrow();
    }

    public List<Product> findAll(){
        return productRepository.findAll();
    }
}
