package com.example.esdproject.DAO;

import com.example.esdproject.Bean.AlumniOrgnisation;

import java.util.List;

public interface AlumniOrganisationDAO {
    boolean addalumniorg(AlumniOrgnisation alumniOrgnisation);
    AlumniOrgnisation updatealumniorg(Integer id,Integer org,AlumniOrgnisation alumniOrgnisation);
    AlumniOrgnisation deletealumniorg(Integer id);
    AlumniOrgnisation changeorgdetails(Integer id,AlumniOrgnisation alumniOrgnisation);
    List<AlumniOrgnisation> getOrgofalumni(Integer id);
}
