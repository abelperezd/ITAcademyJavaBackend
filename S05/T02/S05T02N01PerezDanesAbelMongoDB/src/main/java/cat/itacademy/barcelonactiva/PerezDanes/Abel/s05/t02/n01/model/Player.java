package cat.itacademy.barcelonactiva.PerezDanes.Abel.s05.t02.n01.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


    /*
    – @Entity annotation indicates that the class is a persistent Java class.
    – @Table annotation provides the table that maps this entity.
    – @Id annotation is for the primary key.
    – @GeneratedValue annotation is used to define generation strategy for the primary key. GenerationType.AUTO means Auto Increment field.
    – @Column annotation is used to define the column in database that maps annotated field.
    */

@Document("player")
public class Player {

    //region Attributes
    @Id
    private String id;

    private String name;

    private Date date;

    private List<Integer> numbers = new ArrayList<>();

    //endregion

    //region Constructors

    public Player() {
        super();
    }

    public Player(String name, Date date) {
        super();
        this.name = name;
        this.date = date;
    }

    public Player(String id, String name, Date date) {
        super();
        this.id = id;
        this.name = name;
        this.date = date;
    }

    public Player(String id, String name, Date date, List<Integer> numbers) {
        super();
        this.id = id;
        this.name = name;
        this.date = date;
        this.numbers = numbers;
    }
    public Player(String name, Date date,List<Integer> numbers) {
        super();
        this.name = name;
        this.date = date;
        this.numbers = numbers;
    }

    //endregion

    //region Getters and setters

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getDate() {
        return date;
    }
    public List<Integer> getNumbers() {
        return numbers;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    //endregion

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", date=" + date + "]";
    }

}
