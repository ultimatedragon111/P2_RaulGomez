package dao;

import model.Entrada;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.hql.internal.ast.util.SessionFactoryHelper;
import org.hibernate.query.Query;

import java.util.ArrayList;

public class Dao {
    private Session session;

    public void initSession(){
        SessionFactory sessionFactory = new Configuration().configure()
                .buildSessionFactory();

        // Recupero el objeto de sessión
        session = sessionFactory.openSession();

    }
    public ArrayList<Entrada> ordenes(){
        Transaction tx = null;
        try {
            tx = session.beginTransaction();

            Query query = session.createQuery("FROM Entrada");


            ArrayList<Entrada> a = (ArrayList<Entrada>) query.list();

            tx.commit();
            System.out.println("Saved Successfully.");

            return a;

        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback(); // Rollback si algun error ocurre.
            e.printStackTrace();
        }
        return null;
    }
    private void endSession() {
        session.close();
    }
}
