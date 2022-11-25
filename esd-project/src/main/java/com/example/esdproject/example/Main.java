package com.example.esdproject.example;

import com.example.esdproject.Bean.Alumni;
import com.example.esdproject.DAO.AlumniDAO;
import com.example.esdproject.DAO.DAOImplementation.AlumniDAOimpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Application started");

        runhibernet();
    }
    public static void runhibernet(){
        AlumniDAO aludetails= new AlumniDAOimpl();

        Alumni alu1=new Alumni(3,"alumni3@email.com",123456778);
        aludetails.addAlumni(alu1);
//        alu1.setEmail("alumni1@email.com");
//        long p=123456778;
//        alu1.setPhno(p);
//        alu1.setId(1);

        Alumni alu2=new Alumni(4,"alumni4@email.com",234567890);
        aludetails.addAlumni(alu2);
        System.out.println(alu1.getEmail());
//        p=234567890;
//        alu2.setId(2);
//        alu2.setPhno(p);
//        alu2.setEmail("alumni2@email.com");

        List<Alumni> result= aludetails.getalumnidetails();
        for (Alumni i:result
             ) {
            System.out.println(i+" ");
        }
    }
}