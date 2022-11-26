package com.example.esdproject.DAO;

import com.example.esdproject.Bean.AlumniOrgnisation;

public interface AlumniOrganisationDAO {
    boolean addalumniorg(AlumniOrgnisation alumniOrgnisation);
    AlumniOrgnisation updatealumniorg(Integer id,Integer org,AlumniOrgnisation alumniOrgnisation);
    AlumniOrgnisation deletealumniorg(Integer id);
    AlumniOrgnisation changeorgdetails(Integer id,AlumniOrgnisation alumniOrgnisation);
}
