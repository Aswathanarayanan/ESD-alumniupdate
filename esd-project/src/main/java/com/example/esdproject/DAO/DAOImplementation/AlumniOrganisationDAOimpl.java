package com.example.esdproject.DAO.DAOImplementation;

import com.example.esdproject.Bean.AlumniEducation;
import com.example.esdproject.Bean.AlumniOrgnisation;
import com.example.esdproject.DAO.AlumniOrganisationDAO;
import com.example.esdproject.Util.HibernetSessionUtil;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AlumniOrganisationDAOimpl implements AlumniOrganisationDAO {
    public boolean addalumniorg(AlumniOrgnisation alumniOrgnisation){
        try (Session session = HibernetSessionUtil.getSession()) {  // session created got access of hibernate session object
            Transaction transaction = session.beginTransaction();  // transaction initiated
            session.save(alumniOrgnisation);                                 // using session object to save java object into MySQL
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
    public AlumniOrgnisation updatealumniorg(Integer id,AlumniOrgnisation alumniOrgnisation){
        try (Session session = HibernetSessionUtil.getSession()) {  // session created got access of hibernate session object
            Transaction tx = session.beginTransaction();
            // Transaction tx = session.getTransaction(); // getting the exixitng transaction
            AlumniOrgnisation alumniOrgnisation1 = session.load(AlumniOrgnisation.class, id);
            System.out.println("contactupdate");
            alumniOrgnisation1.setPosition(alumniOrgnisation.getPosition());
            alumniOrgnisation1.setAlumni(alumniOrgnisation.getAlumni());
            alumniOrgnisation1.setOrganisation(alumniOrgnisation.getOrganisation());
            alumniOrgnisation1.setJoingdate(alumniOrgnisation.getJoingdate());
            alumniOrgnisation1.setLeavingdate(alumniOrgnisation.getLeavingdate());
            session.update(alumniOrgnisation1);
            tx.commit();
            return alumniOrgnisation1;
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return null;
        }
    }
}
