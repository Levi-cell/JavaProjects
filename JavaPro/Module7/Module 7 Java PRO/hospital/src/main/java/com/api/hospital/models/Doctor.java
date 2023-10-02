package com.api.hospital.models;

import javax.persistence.*;
import java.util.List;
import java.util.stream.DoubleStream;

@Entity
@Table(name = "tb_doctor")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String office;
    private String department;
    private String telephone;

    public Doctor(Long id, String name, String office, String department, String telephone) {
        this.id = id;
        this.name = name;
        this.office = office;
        this.department = department;
        this.telephone = telephone;
    }

    public Doctor(){

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }


}
