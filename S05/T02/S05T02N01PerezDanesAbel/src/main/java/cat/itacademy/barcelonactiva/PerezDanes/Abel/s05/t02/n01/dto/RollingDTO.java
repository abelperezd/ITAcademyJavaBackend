package cat.itacademy.barcelonactiva.PerezDanes.Abel.s05.t02.n01.dto;

import cat.itacademy.barcelonactiva.PerezDanes.Abel.s05.t02.n01.model.Player;

public class RollingDTO {

    //region Attributes

    private int id;
    private Player player;
    private int number;
    private String result;

    //endregion

    //region Constructors
    public RollingDTO() {

    }

    public RollingDTO(Player player, int number) {
        this.player = player;
        this.number = number;
        setResult(number);
    }

    public RollingDTO(int id, Player player, int number) {
        this.id = id;
        this.player = player;
        this.number = number;
        setResult(number);
    }

    //endregion

    //region Getters and setters

    public int getId() {
        return id;
    }

    public Player getPlayer() {
        return player;
    }

    public int getNumber() {
        return number;
    }

    public String getResult() {
        return result;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setNumber(int number) {
        this.number = number;
        setResult(number);
    }

    private void setResult(int number) {
        result = number == 7 ? "Victory" : "Loss";
    }

    //endregion

    @Override
    public String toString() {
        return "Sucursal [id=" + id + ", nom=" + player + ", pais=" + player + ", tipusSucursal: " + number + "]";
    }

}
