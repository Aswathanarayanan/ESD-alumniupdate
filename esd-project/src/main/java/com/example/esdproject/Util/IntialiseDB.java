package com.example.esdproject.Util;

import com.example.esdproject.Bean.Alumni;
import com.example.esdproject.Bean.AlumniEducation;
import com.example.esdproject.DAO.AlumniEducationDAO;
import com.example.esdproject.DAO.DAOImplementation.AlumniEducationDAOimpl;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class IntialiseDB {
    public static void main(){
        System.out.println("IN main");
        AlumniEducation alumniEducation1=new AlumniEducation();
        alumniEducation1.setId(1);
        alumniEducation1.setDegree("BE");
        alumniEducation1.setPassingyear(2020);
        alumniEducation1.setJoiningyear(2016);
        alumniEducation1.setCollegename("CEG");
        alumniEducation1.setAddress("chennai");
        try (Session session = HibernetSessionUtil.getSession()) {
            //Integer
            List<Alumni> res = new ArrayList<>(session.createQuery("FROM Alumni WHERE id = 2").list());
            alumniEducation1.setAlumni(res.get(0));
        }
        catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }
        AlumniEducationDAO alumniEducationDAO=new AlumniEducationDAOimpl();
        alumniEducationDAO.addeducation(alumniEducation1);
    }
}
