package com.example.esdproject.Service;

import com.example.esdproject.Bean.Alumni;
import com.example.esdproject.DAO.DAOImplementation.AlumniDAOimpl;

import java.util.List;

public class AlumniService {
    com.example.esdproject.DAO.AlumniDAO alumniDAO=new AlumniDAOimpl();

    public List<Alumni> getAlumniList(){
        List<Alumni> alumniList=alumniDAO.getalumnidetails();
        return alumniList;
    }


    public Boolean add_alumni(Alumni alumni){
        System.out.println(String.valueOf(alumni));
        if(alumniDAO.addAlumni(alumni)) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public Alumni getIdAlumnilist(int id){
        Alumni alumni=alumniDAO.getalumnidetailsid(id);
        return alumni;
    }

    public Alumni updatedalumnicontact(int id,Alumni alumni){
        Alumni alu=alumniDAO.updatealumicontact(id,alumni);
        return alu;
    }
}
