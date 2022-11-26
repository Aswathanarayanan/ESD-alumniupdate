package com.example.esdproject.DAO.DAOImplementation;

import com.example.esdproject.Bean.Alumni;
import com.example.esdproject.Bean.AlumniEducation;
import com.example.esdproject.Bean.Organisation;
import com.example.esdproject.DAO.AlumniEducationDAO;
import com.example.esdproject.Util.HibernetSessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AlumniEducationDAOimpl implements AlumniEducationDAO {
    @Override
    public boolean addeducation(AlumniEducation alumniEducation) {
        try (Session session = HibernetSessionUtil.getSession()) {  // session created got access of hibernate session object
            Transaction transaction = session.beginTransaction();  // transaction initiated
            session.save(alumniEducation);                                 // using session object to save java object into MySQL
            transaction.commit();                                  // committing transaction
            return true;
        } catch (
                HibernateException exception) {
            // if Hibernate Exception occurs return false
            // for related exception we can maintain separate logger / Sysout messages for easy debugging
            System.out.println("Hibernate Exception");
            System.out.print(exception.getLocalizedMessage());
            return false;
        } catch (Exception e) {
            //generalized exception class for any IO / Arithmetic Exception
            System.out.print(e.getLocalizedMessage());
            return false;
        }
    }
    public AlumniEducation updateeducation(Integer id,AlumniEducation alumniEducation){
        try (Session session = HibernetSessionUtil.getSession()) {  // session created got access of hibernate session object
            Transaction tx = session.beginTransaction();
            Alumni alumni = session.load(Alumni.class, id);
            //AlumniEducation alumniEducation1=new AlumniEducation();
            System.out.println("educationupdate"+alumniEducation.getPassingyear()+alumniEducation.getCollegename());
//            alumniEducation1.setAddress(alumniEducation.getAddress());
//            alumniEducation1.setCollegename(alumniEducation.getCollegename());
            alumniEducation.setAlumni(alumni);
//            alumniEducation1.setDegree(alumniEducation.getDegree());
//            alumniEducation1.setJoiningyear(alumniEducation.getJoiningyear());
//            alumniEducation1.setPassingyear(alumniEducation.getPassingyear());
            session.save(alumniEducation);
            tx.commit();
            return alumniEducation;
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return null;
        }
    }
}
