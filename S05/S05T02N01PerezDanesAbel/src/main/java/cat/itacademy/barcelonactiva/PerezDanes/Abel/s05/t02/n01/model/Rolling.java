package cat.itacademy.barcelonactiva.PerezDanes.Abel.s05.t02.n01.model;

import jakarta.persistence.*;


    /*
    – @Entity annotation indicates that the class is a persistent Java class.
    – @Table annotation provides the table that maps this entity.
    – @Id annotation is for the primary key.
    – @GeneratedValue annotation is used to define generation strategy for the primary key. GenerationType.AUTO means Auto Increment field.
    – @Column annotation is used to define the column in database that maps annotated field.
    */

@Entity
@Table(name = "rolling")
public class Rolling {

    //region Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne @JoinColumn(name = "player_id" )
    @Column(name = "player_id")
    private int player_id;

    @Column(name = "number")
    private int number;

    //endregion

    //region Constructors

    public Rolling() {

    }

    public Rolling(int player_id, int number) {
        this.player_id = player_id;
        this.number = number;
    }

    public Rolling(int id, int player_id, int number) {
        this.id = id;
        this.player_id = player_id;
        this.number = number;
    }

    //endregion

    //region Getters and setters

    public int getId() {
        return id;
    }

    public int getPlayer_id() {
        return player_id;
    }

    public int getNumber() {
        return number;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPlayer_id(int player_id) {
        this.player_id = player_id;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    //endregion

    @Override
    public String toString() {
        return "Rolling [id=" + id + ", user_id=" + player_id + ", number=" + number + "]";
    }

}
