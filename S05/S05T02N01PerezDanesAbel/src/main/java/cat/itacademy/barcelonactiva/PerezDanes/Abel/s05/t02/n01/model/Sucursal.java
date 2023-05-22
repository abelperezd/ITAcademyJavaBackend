package cat.itacademy.barcelonactiva.PerezDanes.Abel.s05.t02.n01.model;

import jakarta.persistence.*;
import org.springframework.lang.NonNull;


    /*
    – @Entity annotation indicates that the class is a persistent Java class.
    – @Table annotation provides the table that maps this entity.
    – @Id annotation is for the primary key.
    – @GeneratedValue annotation is used to define generation strategy for the primary key. GenerationType.AUTO means Auto Increment field.
    – @Column annotation is used to define the column in database that maps annotated field.
    */

@Entity
@Table(name = "sucursal")
public class Sucursal {

    //region Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "nomSucursal")
    private String nomSucursal;

    @Column(name = "paisSucursal")
    private String paisSucursal;

    //endregion

    //region Constructors

    public Sucursal() {

    }

    public Sucursal(String nomSucursal, String paisSucursal) {
        this.nomSucursal = nomSucursal;
        this.paisSucursal = paisSucursal;
    }

    public Sucursal(int id, String nomSucursal, String paisSucursal) {
        this.id = id;
        this.nomSucursal = nomSucursal;
        this.paisSucursal = paisSucursal;
    }

    //endregion

    //region Getters and setters

    public int getId() {
        return id;
    }

    public String getNomSucursal() {
        return nomSucursal;
    }

    public String getPaisSucursal() {
        return paisSucursal;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNomSucursal(String nomSucursal) {
        this.nomSucursal = nomSucursal;
    }

    public void setPaisSucursal(String paisSucursal) {
        this.paisSucursal = paisSucursal;
    }

    //endregion

    @Override
    public String toString() {
        return "Sucursal [id=" + id + ", nom=" + nomSucursal + ", pais=" + paisSucursal + "]";
    }

}
