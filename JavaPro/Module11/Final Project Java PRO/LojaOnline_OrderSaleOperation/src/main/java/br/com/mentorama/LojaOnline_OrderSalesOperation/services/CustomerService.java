package br.com.mentorama.LojaOnline_OrderSalesOperation.services;

import br.com.mentorama.LojaOnline_OrderSalesOperation.entities.Customer;
import br.com.mentorama.LojaOnline_OrderSalesOperation.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public Customer create(Customer customer){
        customerRepository.save(customer);
        return customer;
    }

    public List<Customer> findAll (){
        return customerRepository.findAll();
    }

    public Customer findById(UUID idCustomer){
        return customerRepository.findById(idCustomer).orElseThrow();
    }
}
