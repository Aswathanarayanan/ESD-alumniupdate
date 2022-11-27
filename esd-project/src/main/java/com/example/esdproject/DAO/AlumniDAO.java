package com.example.esdproject.DAO;

import com.example.esdproject.Bean.Alumni;

import java.util.List;

public interface AlumniDAO {
    boolean addAlumni(Alumni alumniobj);
    List<Alumni> getalumnidetails();
    Alumni getalumnidetailsid(Integer id);

    Alumni updatealumicontact(Integer id,Alumni alumni);
    Alumni loginalumni(Alumni alumni);
}
