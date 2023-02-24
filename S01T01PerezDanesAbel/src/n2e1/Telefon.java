package n2e1;

public class Telefon {

    //region attributes
    private String marca;
    private String model;
    //endregion

    //region getters, setters and constructor
    public Telefon(String marca, String model) {
        this.marca = marca;
        this.model = model;
    }

    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    //endregion

    public void call(String number){
        System.out.println("Calling " + number);
    }
}
