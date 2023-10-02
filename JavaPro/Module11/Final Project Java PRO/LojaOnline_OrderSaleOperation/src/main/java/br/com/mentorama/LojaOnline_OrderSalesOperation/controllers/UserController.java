package br.com.mentorama.LojaOnline_OrderSalesOperation.controllers;

import br.com.mentorama.LojaOnline_OrderSalesOperation.entities.ProductStock;
import br.com.mentorama.LojaOnline_OrderSalesOperation.entities.User;
import br.com.mentorama.LojaOnline_OrderSalesOperation.exceptions.ProduckStockExistException;
import br.com.mentorama.LojaOnline_OrderSalesOperation.services.ProductStockService;
import br.com.mentorama.LojaOnline_OrderSalesOperation.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> create(@RequestBody User newUser) {
            User createdUser = userService.save(newUser);
            return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @PatchMapping("/{idUser}")
    public ResponseEntity<User> update(@PathVariable ("idUser") Integer idUser,
                                       @RequestBody User user) throws ClassNotFoundException{
        User updateUser = userService.findById(idUser);
        if(updateUser != null) {
            updateUser= userService.update(user);
            return new ResponseEntity<>(updateUser, HttpStatus.OK);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário Não Encontrado ");
    }

    @GetMapping("/{idUser}")
    public ResponseEntity<User> findById(@PathVariable("idUser") Integer idUser)
                                throws ClassNotFoundException {
        User findUser = userService.findById(idUser);
        if (findUser != null) {
            return new ResponseEntity<>(userService.findById(idUser), HttpStatus.OK);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário Não Encontrado ");
    }

   @GetMapping
   public ResponseEntity<List<User>> findAll(){
        return  new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }
}
