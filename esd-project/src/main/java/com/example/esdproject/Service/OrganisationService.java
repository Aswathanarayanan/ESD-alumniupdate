package com.example.esdproject.Service;

import com.example.esdproject.Bean.Organisation;
import com.example.esdproject.DAO.DAOImplementation.OrganisationDAOimpl;
import com.example.esdproject.DAO.OrganisationDAO;
import java.util.List;

import java.util.ArrayList;

public class OrganisationService {
    OrganisationDAO organisationDAO=new OrganisationDAOimpl();
    public List<Organisation> getorglist(){
        return organisationDAO.getorglist();
    }
}
