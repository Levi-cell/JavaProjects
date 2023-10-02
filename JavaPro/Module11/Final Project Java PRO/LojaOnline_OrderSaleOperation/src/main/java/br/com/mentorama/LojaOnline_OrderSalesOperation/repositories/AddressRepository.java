package br.com.mentorama.LojaOnline_OrderSalesOperation.repositories;

import br.com.mentorama.LojaOnline_OrderSalesOperation.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;

@Repository
public interface AddressRepository extends JpaRepository<Address, UUID> {

    public Address findByIdCustomer(UUID idCustomer);
}
