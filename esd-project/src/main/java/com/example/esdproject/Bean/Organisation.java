package com.example.esdproject.Bean;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "organisation")
public class Organisation {

    @Id
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column
    private String address;

    public Organisation(){

    }

    public Organisation(int id,String name,String address){
        this.id=id;
        this.name=name;
        this.address=address;
    }

    public Integer getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public String getAddress(){
        return this.address;
    }

    public void setId(Integer id){
        this.id=id;
    }

    public void setName(String name){
        this.name=name;
    }
    public void setAddress(String address){
        this.address=address;
    }
}
