package br.com.mentorama.LojaOnline_OrderSalesOperation.services;

import br.com.mentorama.LojaOnline_OrderSalesOperation.entities.Address;
import br.com.mentorama.LojaOnline_OrderSalesOperation.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AddressService {

    @Autowired
    AddressRepository addressRepository;

    public Address create(Address address){
        addressRepository.save(address);
        return address;
    }

    public Address findByIdCustomer(UUID idCustomer){
        return addressRepository.findByIdCustomer(idCustomer);
    }
}
