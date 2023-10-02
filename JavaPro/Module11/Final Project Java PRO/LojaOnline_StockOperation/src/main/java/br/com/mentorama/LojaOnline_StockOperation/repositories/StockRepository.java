package br.com.mentorama.LojaOnline_StockOperation.repositories;

import br.com.mentorama.LojaOnline_StockOperation.entities.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface StockRepository extends JpaRepository<Stock, UUID> {

    public Stock findByCodeProduct(UUID codeProduct);
}
