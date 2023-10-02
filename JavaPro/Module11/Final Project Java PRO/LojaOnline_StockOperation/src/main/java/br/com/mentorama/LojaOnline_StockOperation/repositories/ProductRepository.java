package br.com.mentorama.LojaOnline_StockOperation.repositories;

import br.com.mentorama.LojaOnline_StockOperation.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {

    public List<Product> findByNameProduct(String nameProduct);
}
