package model;


import javax.persistence.*;

@Entity
@Table(name= "Bodega")
public class Bodega {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = true)
    private int id;

    @Column
    private String nombre;

    Bodega(){}

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

    @Override
    public String toString() {
        return "Bodega{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
