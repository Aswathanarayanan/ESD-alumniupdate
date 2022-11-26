package com.example.esdproject.DAO;

import com.example.esdproject.Bean.AlumniOrgnisation;

public interface AlumniOrganisationDAO {
    boolean addalumniorg(AlumniOrgnisation alumniOrgnisation);
    AlumniOrgnisation updatealumniorg(Integer id,AlumniOrgnisation alumniOrgnisation);
}
