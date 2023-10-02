package br.com.mentorama.LojaOnline_OrderSalesOperation.repositories;

import br.com.mentorama.LojaOnline_OrderSalesOperation.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
