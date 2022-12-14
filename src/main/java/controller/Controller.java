package controller;

import com.mysql.cj.Session;
import dao.Dao;
import model.Bodega;
import model.Campo;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.transaction.Transaction;

public class Controller {
    Dao dao;
    Campo campo;
    Bodega bodega;
    private Session session;
    private Transaction tx;
    public Controller(){
        dao = new Dao();
    }
    public void init() {

        Configuration cfg = new Configuration().configure();

        SessionFactory factory = cfg.buildSessionFactory();

    }
}
