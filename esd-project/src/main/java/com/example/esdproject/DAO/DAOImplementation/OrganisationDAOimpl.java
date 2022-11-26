package com.example.esdproject.DAO.DAOImplementation;

import com.example.esdproject.Bean.Organisation;
import com.example.esdproject.DAO.OrganisationDAO;
import com.example.esdproject.Util.HibernetSessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class OrganisationDAOimpl implements OrganisationDAO {
    @Override
    public boolean addOrganisation(Organisation organisation) {
        try (Session session = HibernetSessionUtil.getSession()) {  // session created got access of hibernate session object
            Transaction transaction = session.beginTransaction();  // transaction initiated
            session.save(organisation);                                 // using session object to save java object into MySQL
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
}
