package br.com.mentorama.LojaOnline_StockOperation.services;

import br.com.mentorama.LojaOnline_StockOperation.entities.Stock;
import br.com.mentorama.LojaOnline_StockOperation.repositories.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class StockService {

    private Stock stock;

    @Autowired
    private StockRepository stockRepository;

    public Stock saveStock(Stock stock){
        return stockRepository.save(stock);
    }

    public Stock findStockByIdProduct(UUID codeProduct) {
        return stockRepository.findByCodeProduct(codeProduct);
    }

    public List<Stock> findAll(){
        return stockRepository.findAll();
    }




}
