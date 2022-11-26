package com.example.esdproject.Bean;

import jakarta.persistence.*;

@Entity
@Table(name = "alumniorgnisation")
public class AlumniOrgnisation {

    @Id
    @Column
    private Integer id;

    @Column
    private String position;

    @Column(nullable = false)
    private String joingdate;

    @Column(nullable = false)
    private String leavingdate;

    @ManyToOne
    @JoinColumn(name = "orgid")
    private Organisation organisation;

    @ManyToOne
    @JoinColumn(name = "alumniid")
    private Alumni alumni;

    public AlumniOrgnisation(){

    }

    public void setId(Integer id){
        this.id=id;
    }

    public void setPosition(String position){
        this.position=position;
    }
    public void setJoingdate(String joingdate){
        this.joingdate=joingdate;
    }
    public void setLeavingdate(String leavingdate){
        this.leavingdate=leavingdate;
    }
    public void setAlumni(Alumni alumni){
        this.alumni=alumni;
    }
    public void setOrganisation(Organisation organisation){
        this.organisation=organisation;
    }

    public Integer getId(){return this.id;}
    public String getPosition(){return this.position;}
    public String getJoingdate(){return this.joingdate;}
    public String getLeavingdate(){return this.leavingdate;}
    public Alumni getAlumni(){return this.alumni;}
    public Organisation getOrganisation(){return this.organisation;}
}
