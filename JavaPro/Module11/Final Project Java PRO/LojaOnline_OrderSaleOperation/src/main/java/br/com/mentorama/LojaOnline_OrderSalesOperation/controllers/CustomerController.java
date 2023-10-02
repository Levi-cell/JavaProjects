package br.com.mentorama.LojaOnline_OrderSalesOperation.controllers;

import br.com.mentorama.LojaOnline_OrderSalesOperation.entities.Address;
import br.com.mentorama.LojaOnline_OrderSalesOperation.entities.Customer;
import br.com.mentorama.LojaOnline_OrderSalesOperation.services.AddressService;
import br.com.mentorama.LojaOnline_OrderSalesOperation.services.CustomerService;
import br.com.mentorama.LojaOnline_OrderSalesOperation.services.ProductStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private AddressService addressService;

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer newCustomer){
         Customer customer = customerService.create(newCustomer);
         return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }

    @PostMapping("/address/{idCustomer}")
    public ResponseEntity<Address> createAddress(@RequestBody Address newAddress,
                                                 @PathVariable UUID idCustomer){
        newAddress.setIdCustomer(idCustomer);
        Address address = addressService.create(newAddress);
        return new ResponseEntity<>(address, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Customer>> findAll(){

        return new ResponseEntity<>(customerService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/address/{idCustomer}")
    public ResponseEntity<Address> findByIdCustomer(@PathVariable("idCustomer") UUID idCustomer){
        return new ResponseEntity<>(addressService.findByIdCustomer(idCustomer), HttpStatus.OK);
    }
}
