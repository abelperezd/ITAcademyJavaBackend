package cat.itacademy.barcelonactiva.PerezDanes.Abel.s04.t02.n02.model;

import jakarta.persistence.*;


    /*
    – @Entity annotation indicates that the class is a persistent Java class.
    – @Table annotation provides the table that maps this entity.
    – @Id annotation is for the primary key.
    – @GeneratedValue annotation is used to define generation strategy for the primary key. GenerationType.AUTO means Auto Increment field.
    – @Column annotation is used to define the column in database that maps annotated field.
    */

@Entity
@Table(name = "fruita")
public class Fruita {

    //reguion Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "quantitatQuilos")
    private int quantitatQuilos;

    //endregion

    //region Constructors
    public Fruita() {

    }

    public Fruita(String nom, int quantitatQuilos) {
        this.nom = nom;
        this.quantitatQuilos = quantitatQuilos;
    }

    public Fruita(long id, String nom, int quantitatQuilos) {
        this.id = id;
        this.nom = nom;
        this.quantitatQuilos = quantitatQuilos;
    }

    //endregion

    //region Getters and setters

    public long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public int getQuantitatQuilos() {
        return quantitatQuilos;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setQuantitatQuilos(int quantitatQuilos) {
        this.quantitatQuilos = quantitatQuilos;
    }

    //endregion

    @Override
    public String toString() {
        return "Fruita [id=" + id + ", nom=" + nom + ", quantitatQuilos=" + quantitatQuilos + "]";
    }

}
