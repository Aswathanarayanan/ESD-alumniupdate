package com.example.esdproject.Bean;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "alumni")
public class Alumni {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "email",unique = true)
    private String email;

    @Column(name = "phonenumber")
    private String phno;

    @Column(name = "password")
    private String password;

    public Alumni(){

    }
    public Alumni(int i,String e,String p,String password){
        this.phno=p;
        this.email=e;
        this.id=i;
        this.password=password;
    }
    public void setEmail(String e){this.email=e;}
    public void setPhno(String p){this.phno=p;}
    public void setId(int i){this.id=i;}

    public void setPassword(String password){this.password=password;}
    public int getId(){return this.id;}
    public String getEmail(){return this.email;}

    public String getPhno() {
        return this.phno;
    }
    public String getPassword(){ return this.password;}
}
