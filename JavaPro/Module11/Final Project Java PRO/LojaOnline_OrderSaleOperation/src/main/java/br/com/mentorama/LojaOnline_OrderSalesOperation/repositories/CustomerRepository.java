package br.com.mentorama.LojaOnline_OrderSalesOperation.repositories;

import br.com.mentorama.LojaOnline_OrderSalesOperation.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, UUID> {
}
