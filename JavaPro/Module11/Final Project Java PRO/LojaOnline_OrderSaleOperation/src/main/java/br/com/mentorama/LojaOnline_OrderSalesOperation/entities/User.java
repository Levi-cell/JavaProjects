package br.com.mentorama.LojaOnline_OrderSalesOperation.entities;

import br.com.mentorama.LojaOnline_OrderSalesOperation.entities.enums.UserType;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;


@Entity
@Table (name = "TB_users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idUser;

    @Column(nullable = false)
    String nameUser;

    @Column(nullable = false)
    UserType userType;

    @Column(nullable = false)
    String passwordUser;


    public User(Integer idUser, String nameUser, UserType userType, String passwordUser) {
        this.idUser = idUser;
        this.nameUser = nameUser;
        this.userType = userType;
        this.passwordUser = passwordUser;
    }

    public User (){}

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public String getPasswordUser() {
        return passwordUser;
    }

    public void setPasswordUser(String passwordUser) {
        this.passwordUser = passwordUser;
    }
}
