package cat.itacademy.barcelonactiva.PerezDanes.Abel.s05.t02.n01.dto;

public class RollingDTO {

    //region Attributes

    private int id;
    private int player_id;
    private int number;
    private String result;

    //endregion

    //region Constructors
    public RollingDTO() {

    }

    public RollingDTO(int player_id, int number) {
        this.player_id = player_id;
        this.player_id = number;
        setResult(number);
    }

    public RollingDTO(int id, int player_id, int number) {
        this.id = id;
        this.player_id = player_id;
        this.player_id = number;
        setResult(number);
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

    public String getResult() {
        return result;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setPlayer_id(int player_id) {
        this.player_id = player_id;
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
        return "Sucursal [id=" + id + ", nom=" + player_id + ", pais=" + player_id + ", tipusSucursal: " + number + "]";
    }

}
