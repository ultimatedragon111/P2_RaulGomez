package model;

import utils.TipoVid;

import javax.persistence.*;



@Entity
@Table(name= "Vid")
public class Vid {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = true)
    private int id;

    @Column
    private int cantidad;

    @Column
    private TipoVid tipo_vid;


    public Vid(){}
    public Vid(int cantidad,TipoVid tipoVid){
        this.cantidad = cantidad;
        this.tipo_vid = tipoVid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public TipoVid getTipo_vid() {
        return tipo_vid;
    }

    public void setTipo_vid(TipoVid tipo_vid) {
        this.tipo_vid = tipo_vid;
    }

    @Override
    public String toString() {
        return "Vid{" +
                "cantidad=" + cantidad +
                ", tipo_vid=" + tipo_vid +
                '}';
    }
}
