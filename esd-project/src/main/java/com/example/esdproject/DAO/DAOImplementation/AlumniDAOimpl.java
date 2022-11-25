package com.example.esdproject.DAO.DAOImplementation;

import com.example.esdproject.Bean.Alumni;
import com.example.esdproject.DAO.AlumniDAO;
import com.example.esdproject.Util.HibernetSessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class AlumniDAOimpl implements AlumniDAO {
    @Override
    public boolean addAlumni(Alumni alumniobj) {
        try(Session session = HibernetSessionUtil.getSession()){  // session created got access of hibernate session object
            Transaction transaction = session.beginTransaction();  // transaction initiated
            session.save(alumniobj);                                 // using session object to save java object into MySQL
            transaction.commit();                                  // committing transaction
            return true;
        }
        catch (HibernateException exception) {
            // if Hibernate Exception occurs return false
            // for related exception we can maintain separate logger / Sysout messages for easy debugging
            System.out.println("Hibernate Exception");
            System.out.print(exception.getLocalizedMessage());
            return false;
        }
        catch (Exception e){
            //generalized exception class for any IO / Arithmetic Exception
            System.out.print(e.getLocalizedMessage());
            return false;
        }
    }

    @Override
    public List<Alumni> getalumnidetails() {
        try (Session session = HibernetSessionUtil.getSession()){
            List<Alumni> alumniList = new ArrayList<>();
            for (final Object d : session.createQuery("from Alumni").list()) {
                alumniList.add((Alumni) d);
            }
            return alumniList;

        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return null;
        }
    }
    public Alumni getalumnidetailsid(Integer aluid){
        try (Session session = HibernetSessionUtil.getSession()) {
            Alumni test = new Alumni();
            List<Object> res = new ArrayList<>(session.createQuery("FROM Alumni WHERE id = :aluid")
                        .setParameter("aluid", aluid).list());
            test=(Alumni) res.get(0);
            System.out.println("Hello"+test.getEmail());
            return (Alumni) res.get(0);
        }
        catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return null;
        }
    }

    public Alumni updatealumicontact(Integer id,Alumni alumni) {
        try (Session session = HibernetSessionUtil.getSession()) {  // session created got access of hibernate session object
            Transaction tx = session.beginTransaction();
           // Transaction tx = session.getTransaction(); // getting the exixitng transaction
            Alumni alumni1 = session.load(Alumni.class, id);
            System.out.println("contactupdate"+alumni.getEmail());
            alumni1.setEmail(alumni.getEmail());
            alumni1.setPhno(alumni.getPhno());
            session.update(alumni1);
            tx.commit();
            return alumni1;
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return null;
        }
    }
}
