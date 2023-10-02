package br.com.mentorama.LojaOnline_OrderSalesOperation.services;

import br.com.mentorama.LojaOnline_OrderSalesOperation.entities.ProductStock;
import br.com.mentorama.LojaOnline_OrderSalesOperation.exceptions.ProduckStockExistException;
import br.com.mentorama.LojaOnline_OrderSalesOperation.repositories.ProductStockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductStockService {

    @Autowired
    ProductStockRepository productStockRepository;

    private boolean productStockAlreadyExists(List<ProductStock> productStocks,
                                              ProductStock productStock){
     Optional<ProductStock> maybeProductStock = productStocks.stream()
             .filter(ps -> ps.getIdProduct() == productStock.getIdProduct())
             .findFirst();
             return maybeProductStock.isPresent();
    }

    public ProductStock save(ProductStock productStock) throws ProduckStockExistException {
        List<ProductStock> productStocks = productStockRepository.findAll();
        if(productStockAlreadyExists(productStocks, productStock)){
            throw new ProduckStockExistException();
        }
        productStockRepository.save(productStock);
        return productStock;
    }

    public ProductStock increaseQuantityOfProductStock (ProductStock productStock){
        int increaseQuantity = productStock.getQuantityStock();
        ProductStock persistedProductStock = productStockRepository
               .findById(productStock.getIdProduct()).orElseThrow();
        persistedProductStock.increaseQuantity(increaseQuantity);
        return productStockRepository.save(persistedProductStock);
    }

    public List<ProductStock> findAll (){
        return productStockRepository.findAll();
    }

    public ProductStock findById(UUID idProduct){
        return productStockRepository.findById(idProduct).orElseThrow();
    }

    public ProductStock findByName (String nameProduct){
        return productStockRepository.findByNameProduct(nameProduct);
    }
}
