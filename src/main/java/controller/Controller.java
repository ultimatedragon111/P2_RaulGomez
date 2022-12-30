package controller;

import dao.Dao;
import model.Bodega;
import model.Campo;
import model.Entrada;
import model.Vid;
import utils.TipoVid;

import java.util.Locale;

public class Controller {
    Dao dao;
    Campo campo;
    Bodega bodega;

    public Controller(){
        dao = new Dao();
    }
    public void init() {

        dao.initSession();
        procesarOrdenes();
        listadoCampos();
        dao.endSession();

    }

    private void procesarOrdenes() {
        for (Entrada entrada : dao.takeOrdenes()) {
            System.out.println(entrada.getInstruccion());
            String[] orden = entrada.getInstruccion().split(" ");
            switch (orden[0]) {
                case "B":
                    addBodega(orden[1]);
                    break;
                case "V":
                    addVid(orden[1],Integer.parseInt(orden[2]));
                    break;
                case "C":
                    addCampo();
                    break;
                case "#":
                   vendimia();
                   break;
            }
        }
    }

    private void addBodega(String name){
        bodega = new Bodega(name);
        dao.addBodega(bodega);
    }

    private void addVid(String tipoVid,int cantidad){
        if (tipoVid.toLowerCase(Locale.ROOT).equals("blanca")) {
            campo.addVid(new Vid(cantidad, TipoVid.BLANCA));

        } else {
            campo.addVid(new Vid(cantidad, TipoVid.NEGRA));
        }
        dao.addVid(campo.getVids().get((campo.getVids().size() - 1)));
    }

    private void addCampo(){
        campo = new Campo(bodega);
        dao.addCampo(campo);
    }

    private void vendimia(){
        for (Vid vid : campo.getVids()) {
            bodega.addVid(vid);
            dao.addVid(vid);
        }
    }

    private void listadoCampos(){
        for(Campo campo: dao.takeCampos()){
            System.out.println(campo.toString());
        }
    }

}
