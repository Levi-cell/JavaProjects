package br.com.mentorama.LojaOnline_OrderSalesOperation.repositories;

import br.com.mentorama.LojaOnline_OrderSalesOperation.entities.ProductStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductStockRepository extends JpaRepository<ProductStock, UUID> {

    public ProductStock findByNameProduct(String nameProduct);
}
