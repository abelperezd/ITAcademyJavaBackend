package cat.itacademy.barcelonactiva.PerezDanes.Abel.s05.t02.n01.model;

public class Rolling {

    //region Attributes

    private int number;
    private String result;

    //endregion

    //region Constructors

    public Rolling(int number) {
        this.number = number;
        setResult(number);
    }

    //endregion

    //region Getters and setters

    public int getNumber() {
        return number;
    }

    public String getResult() {
        return result;
    }


    private void setResult(int number) {
        result = number == 7 ? "Victory" : "Loss";
    }

    //endregion

    @Override
    public String toString() {
        return "Rolling [number: " + number + "]";
    }
}
