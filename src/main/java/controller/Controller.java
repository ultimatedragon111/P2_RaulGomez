package controller;

import dao.Dao;
import model.Bodega;
import model.Campo;

public class Controller {
    Dao dao;
    Campo campo;
    Bodega bodega;
    public Controller(){
        dao = new Dao();
    }
    public void init() {

    }
}
