package controller;

import com.mysql.cj.Session;
import dao.Dao;
import model.Bodega;
import model.Campo;
import model.Entrada;
import model.Vid;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import utils.TipoVid;

import javax.transaction.Transaction;
import java.util.ArrayList;
import java.util.Locale;

public class Controller {
    Dao dao;
    Campo campo;
    Bodega bodega;
    //Vid vid;


    public Controller(){
        dao = new Dao();
    }
    public void init() {

        dao.initSession();
        for(Entrada entrada: dao.ordenes()){
            String[] orden = entrada.getInstruccion().split(" ");
            switch(orden[0]){
                case "B":
                    bodega = new Bodega(orden[1]);
                    dao.addBodega(bodega);
                    break;
                case "V":
                    if(orden[1].toLowerCase(Locale.ROOT).equals("blanca")){
                        dao.addVid(new Vid(Integer.parseInt(orden[2]),TipoVid.BLANCA,campo));
                    }
                    else{
                        dao.addVid(new Vid(Integer.parseInt(orden[2]),TipoVid.NEGRA,campo));
                    }
                    break;
                case "C":
                    campo = new Campo(bodega);
                    dao.addCampo(campo);
                    break;
                case "#":
                    for(Vid vid: dao.takeVids(campo)){
                        vid.setBodega(bodega);
                        dao.addVid(vid);
                    }
                    break;
            }
        }
        dao.endSession();

    }
}
