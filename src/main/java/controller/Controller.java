package controller;

import com.mysql.cj.Session;
import dao.Dao;
import model.Bodega;
import model.Campo;
import model.Entrada;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.transaction.Transaction;
import java.util.ArrayList;

public class Controller {
    Dao dao;
    Campo campo;
    Bodega bodega;


    public Controller(){
        dao = new Dao();
    }
    public void init() {
        dao.initSession();
        for(Entrada entrada: dao.ordenes()){
            String[] orden = entrada.getInstruccion().split(" ");
            switch(orden[0]){
                case "B":
                    break;
                case "V":
                    break;
                case "C":
                    break;
                case "#":
                    break;
            }
        }

    }
}
