package com.spring.products.Models;

public class Product {
    private Long id;
    private String name;
    private Double preco;
    private Integer quantityPorcentage;
    private Double maximumDiscountPercentage;

    public Product(Long id, String nome, Double preco, Integer quantidadeEmEstoque, Double maxDiscontoPorcentagem) {
        this.id = id;
        this.name = nome;
        this.preco = preco;
        this.quantityPorcentage = quantidadeEmEstoque;
        this.maximumDiscountPercentage = maxDiscontoPorcentagem;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "Product{" +
                "id: " + id +
                ", nomeProduto: '" + name + '\'' +
                ", preco: " + preco +
                ", quantidadeEmEstoque: " + quantityPorcentage + '\''+
                ", maxDiscontoPorcentagem: " + maximumDiscountPercentage
                ;
    }

    public double getDiscountPrice(final Double disconto){
        if(disconto > maximumDiscountPercentage){
            return preco*(1- maximumDiscountPercentage);
        }
        else {
            return preco *(1- disconto);
        }
    }

    public Integer getQuantityOfProductAvailable(final Integer ofertaDisponivel){
        if (ofertaDisponivel > quantityPorcentage){
            final String message = "Quantidade indisponivel no Stock, coloque um valor válido";
            System.out.println(message + quantityPorcentage);
            return quantityPorcentage;
        } else {
            return ofertaDisponivel;
        }
    }
}
