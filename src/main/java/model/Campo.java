package model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @OneToMany()
    @JoinColumn(name = "campo_id")
    List<Vid> vids = new ArrayList<>();




    public Campo(){}

    public Campo(Bodega bodega) {
        this.bodega = bodega;
    }

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
        return "Campo{" +
                "id=" + id +
                ", vids=" + vids +
                ", bodega=" + bodega +
                '}';
    }
}
