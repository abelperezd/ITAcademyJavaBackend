package cat.itacademy.barcelonactiva.PerezDanes.Abel.s05.t02.n01.dto;

import java.util.Date;
import java.util.List;

public class PlayerDTO {

    //region Attributes

    private int id;
    private String name;
    private Date date;
    private float averageScore;

    //endregion

    //region Constructors
    public PlayerDTO() {

    }

    public PlayerDTO(String name, Date date) {
        this.name = name;
        this.date = date;
    }

    public PlayerDTO(int id, String name, Date date) {
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

    public float getAverageScore() {
        return averageScore;
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

    public void setAverageScore(float score) {
        averageScore = score;
    }

    //endregion

    @Override
    public String toString() {
        return "Sucursal [id=" + id + ", nom=" + name + ", pais=" + name + ", tipusSucursal: " + date + "]";
    }

}
