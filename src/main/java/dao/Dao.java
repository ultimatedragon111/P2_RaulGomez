package dao;

import model.Bodega;
import model.Campo;
import model.Entrada;
import model.Vid;
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

        session = sessionFactory.openSession();

    }
    public ArrayList<Entrada> takeOrdenes(){
        Transaction tx = null;
        try {
            tx = session.beginTransaction();

            Query query = session.createQuery("FROM Entrada");

            tx.commit();

            return (ArrayList<Entrada>) query.list();

        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        }
        return null;
    }
    public void addBodega(Bodega bodega){
        Transaction tx = null;
        try {
            tx = session.beginTransaction();

            session.save(bodega);

            tx.commit();

        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        }
    }
    public void addCampo(Campo campo){
        Transaction tx = null;
        try {
            tx = session.beginTransaction();

            session.save(campo);

            tx.commit();

        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        }

    }
    public void addVid(Vid vid){
        Transaction tx = null;
        try {
            tx = session.beginTransaction();

            session.save(vid);

            tx.commit();

        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        }
    }

    public ArrayList<Campo> takeCampos(){
        Transaction tx = null;
        try {
            tx = session.beginTransaction();

            Query query = session.createQuery("FROM Campo");

            tx.commit();

            return (ArrayList<Campo>) query.list();

        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        }
        return null;
    }

    public void endSession() {
        session.close();
    }
}
