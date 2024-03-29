package com.example.esdproject.Service;

import com.example.esdproject.Bean.AlumniOrgnisation;
import com.example.esdproject.Bean.Organisation;
import com.example.esdproject.DAO.AlumniOrganisationDAO;
import com.example.esdproject.DAO.DAOImplementation.AlumniOrganisationDAOimpl;

import java.util.List;

public class AlumniOrganisationService {
    AlumniOrganisationDAO alumniOrganisationDAO=new AlumniOrganisationDAOimpl();
    public AlumniOrgnisation updateorganisation(Integer id,Integer org,AlumniOrgnisation alumniOrgnisation){
        return alumniOrganisationDAO.updatealumniorg(id,org,alumniOrgnisation);
    }
    public AlumniOrgnisation deleteorganisation(Integer id){
        return alumniOrganisationDAO.deletealumniorg(id);
    }
    public AlumniOrgnisation changeorgdetails(Integer id,AlumniOrgnisation alumniOrgnisation){
        return alumniOrganisationDAO.changeorgdetails(id, alumniOrgnisation);
    }
    public List<AlumniOrgnisation> getalumniorg(Integer id){
        return alumniOrganisationDAO.getOrgofalumni(id);
    }
}
