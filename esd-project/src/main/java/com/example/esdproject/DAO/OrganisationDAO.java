package com.example.esdproject.DAO;

import com.example.esdproject.Bean.Alumni;
import com.example.esdproject.Bean.Organisation;
import java.util.List;

import java.util.ArrayList;

public interface OrganisationDAO {
    boolean addOrganisation(Organisation orgobj);
    List<Organisation> getorglist();
}
