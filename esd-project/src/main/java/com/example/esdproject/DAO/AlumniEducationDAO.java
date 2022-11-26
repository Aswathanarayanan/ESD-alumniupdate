package com.example.esdproject.DAO;

import com.example.esdproject.Bean.AlumniEducation;

public interface AlumniEducationDAO {
    boolean addeducation(AlumniEducation alumniEducation);
    AlumniEducation updateeducation(Integer id,AlumniEducation alumniEducation);
}
