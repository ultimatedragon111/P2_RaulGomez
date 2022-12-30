package model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name= "Bodega")
public class Bodega {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = true)
    private int id;

    @Column
    private String nombre;

    @OneToMany()
    @JoinColumn(name = "bodega_id")
    List<Vid> vids = new ArrayList<>();;

    public Bodega(){}

    public Bodega(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public List<Vid> getVids() {
        return vids;
    }

    public void setVids(List<Vid> vids) {
        this.vids = vids;
    }
    public void addVid(Vid vid){
        this.vids.add(vid);
    }

    @Override
    public String toString() {
        return "Bodega{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", vids=" + vids +
                '}';
    }
}
