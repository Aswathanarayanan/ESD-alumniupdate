package com.example.esdproject.Bean;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "alumni")
public class Alumni {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "email")
    private String email;

    @Column(name = "phonenumber")
    private long phno;

    public Alumni(){

    }
    public Alumni(int i,String e,long p){
        this.phno=p;
        this.email=e;
        this.id=i;
    }
    public void setEmail(String e){this.email=e;}
    public void setPhno(Long p){this.phno=p;}
    public void setId(int i){this.id=i;}

    public int getId(){return id;}
    public String getEmail(){return email;}

    public long getPhno() {
        return phno;
    }
}
