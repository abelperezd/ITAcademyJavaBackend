package cat.itacademy.barcelonactiva.PerezDanes.Abel.s05.t02.n01.model;

import jakarta.persistence.*;

import java.util.Date;


    /*
    – @Entity annotation indicates that the class is a persistent Java class.
    – @Table annotation provides the table that maps this entity.
    – @Id annotation is for the primary key.
    – @GeneratedValue annotation is used to define generation strategy for the primary key. GenerationType.AUTO means Auto Increment field.
    – @Column annotation is used to define the column in database that maps annotated field.
    */

@Entity
@Table(name = "player")
public class Player {

    //region Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "date")
    private Date date;

    //endregion

    //region Constructors

    public Player() {

    }

    public Player(String name, Date date) {
        this.name = name;
        this.date = date;
    }

    public Player(int id, String name, Date date) {
        this.id = id;
        this.name = name;
        this.date = date;
    }

    //endregion

    //region Getters and setters

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getDate() {
        return date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    //endregion

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", date=" + date + "]";
    }

}
