package com.example.esdproject.Bean;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;

@Entity
@Table(name = "alumnieducation")
public class AlumniEducation {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "degree",nullable = false)
    private String degree;

    @Column(name = "passingyear",nullable = false)
    private Integer passingyear;

    @Column(name = "joiningyear",nullable = false)
    private Integer joiningyear;

    @Column(name = "collegename")
    private String collegename;

    @Column(name = "address")
    private String address;

//    @ManyToOne
//    @JoinColumn(name = "alumniid")
//    private Alumni alumni;

    public void setId(Integer id){
        this.id=id;
    }
    public void setAddress(String address){
        this.address=address;
    }
    public void setDegree(String address){
        this.degree=degree;
    }
    public void setPassingyear(Integer passingyear){
        this.passingyear=passingyear;
    }
    public void setJoiningyear(Integer joiningyear){
        this.joiningyear=joiningyear;
    }
    public void setCollegename(String collegename){
        this.collegename=collegename;
    }
//    public void setAlumni(Alumni alumni){
//        this.alumni=alumni;
//    }

    public String getAddress(){
        return this.address;
    }
    public String getDegree(){
        return this.degree;
    }
    public Integer getPassingyear(){
        return this.passingyear;
    }
    public Integer getJoiningyear(){
        return this.passingyear;
    }
    public String getCollegename(){
        return this.collegename;
    }
//    public Alumni getAlumni(){
//        return this.alumni;
//    }
}
