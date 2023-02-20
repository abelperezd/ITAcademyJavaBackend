package n1e2;

public class Cotxe {

    ///region Attributes

    private static final String marca = "Seat";
    private static String model;
    private final int potencia = 100;

    ///endregion

    ///region Getters

    public static String getMarca() {
        return marca;
    }

    public static String getModel() {
        return model;
    }

    public int getPotencia() {
        return potencia;
    }

    ///endregion

    public Cotxe(String model) {
        this.model = model;
    }

    static void frenar() {
        System.out.println("El vehicle està frenant");
    }

    void accelerar() {
        System.out.println("El vehicle està accelerant");
    }

}
