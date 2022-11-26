package com.example.esdproject.Service;

import com.example.esdproject.Bean.AlumniEducation;
import com.example.esdproject.DAO.AlumniEducationDAO;
import com.example.esdproject.DAO.DAOImplementation.AlumniEducationDAOimpl;

public class AlumniEducationService {
    AlumniEducationDAO alumniEducationDAO=new AlumniEducationDAOimpl();
    public AlumniEducation updatealumnieducation(Integer id,AlumniEducation alumniEducation){
        return alumniEducationDAO.updateeducation(id,alumniEducation);
    }
}
