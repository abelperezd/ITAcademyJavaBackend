package cat.itacademy.barcelonactiva.PerezDanes.Abel.s05.t02.n01.dto;

import cat.itacademy.barcelonactiva.PerezDanes.Abel.s05.t02.n01.model.Rolling;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PlayerDTO {

    //region Attributes

    private String id = null;
    private String name;
    private Date date;

    private List<Integer> numbers = new ArrayList<>();
    private float averageScore;

    //endregion

    //region Constructors
    public PlayerDTO() {

    }

    public PlayerDTO(String name, Date date) {
        this.name = name;
        this.date = date;
    }

    public PlayerDTO(String id, String name, Date date) {
        this.id = id;
        this.name = name;
        this.date = date;
    }

    public PlayerDTO(String id, String name, Date date, List<Integer> numbers) {
        this.id = id;
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

    public float getAverageScore() {
        return averageScore;
    }


    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate() {
        //to avoid overriding the creation date
        if (date == null)
            this.date = new Date(System.currentTimeMillis());
    }

    public void setAverageScore(float score) {
        averageScore = score;
    }

    public void setAverageScore(List<Rolling> rollings) {
        float counter = 0;

        for (Rolling r : rollings) {
            counter += r.getResult().compareToIgnoreCase("Victory") == 0 ? 1 : 0;
        }
        averageScore = (float) counter / rollings.size() * 100;
    }

    //endregion

    @Override
    public String toString() {
        return "Player [id=" + id + ", name=" + name + ", date=" + date + ", averageScore: " + averageScore + "]";
    }

}
