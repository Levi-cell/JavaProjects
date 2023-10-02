package br.com.mentorama.LojaOnline_OrderSalesOperation.services;

import br.com.mentorama.LojaOnline_OrderSalesOperation.entities.User;
import br.com.mentorama.LojaOnline_OrderSalesOperation.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User save(User user){
        userRepository.save(user);
        return user;
    }

    public List<User> findAll (){
        return userRepository.findAll();
    }

    public User findById(Integer idUser){
        return userRepository.findById(idUser).orElseThrow();
    }

    public User update(User user) throws ClassNotFoundException {
        if (userRepository.existsById(user.getIdUser())) {
            return userRepository.save(user);
        }
        throw new ClassNotFoundException("Usuário Não Existe !");
    }

    public void delete(Integer idUser) throws ClassNotFoundException {
        if (userRepository.existsById(idUser)){
            User user = userRepository.findById(idUser).orElseThrow();
            userRepository.delete(user);
        }
        throw new ClassNotFoundException("Usuário Não Existe !");
    }
}

