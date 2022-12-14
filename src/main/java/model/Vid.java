package model;

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
    private int tipo_vid;

    @OneToOne()
    @JoinColumn(name = "bodega_id")
    private Bodega bodega;

    @OneToOne()
    @JoinColumn(name = "campo_id")
    private Campo campo;

    Vid(){}

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

    public int getTipo_vid() {
        return tipo_vid;
    }

    public void setTipo_vid(int tipo_vid) {
        this.tipo_vid = tipo_vid;
    }

    public Bodega getBodega() {
        return bodega;
    }

    public void setBodega(Bodega bodega) {
        this.bodega = bodega;
    }

    public Campo getCampo() {
        return campo;
    }

    public void setCampo(Campo campo) {
        this.campo = campo;
    }

    @Override
    public String toString() {
        return "Vid{" +
                "id=" + id +
                ", cantidad=" + cantidad +
                ", tipo_vid=" + tipo_vid +
                ", bodega=" + bodega +
                ", campo=" + campo +
                '}';
    }
}
