package model;

import javax.persistence.*;

@Entity
@Table(name= "Campo")
public class Campo {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = true)
    private int id;

    @OneToOne()
    @JoinColumn(name = "id_bodega")
    private Bodega bodega;

    public Campo(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Bodega getBodega() {
        return bodega;
    }

    public void setBodega(Bodega bodega) {
        this.bodega = bodega;
    }

    @Override
    public String toString() {
        return "Campo{" +
                "id=" + id +
                ", bodega=" + bodega +
                '}';
    }
}
