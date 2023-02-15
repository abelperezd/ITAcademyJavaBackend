package n1e2;

public class Cotxe {
    static final String marca = "Seat";
    static String model;
    private final int potencia = 100;

    public int getPotencia() {
        return potencia;
    }

    public Cotxe(String model) {
        this.model = model;
    }

    static void Frenar() {
        System.out.println("El vehicle està frenant");
    }

    void Accelerar() {
        System.out.println("El vehicle està accelerant");
    }

}
