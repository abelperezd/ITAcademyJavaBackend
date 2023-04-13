package n3;

public class Main {
    public static void main(String[] args) {
        Parking parking = new Parking();

        parking.addArrencar(new Avio());
        parking.addArrencar(new Vaixell());

        parking.addAccelerar(new Cotxe());
        parking.addAccelerar(new Avio());
        parking.addAccelerar(new Vaixell());

        parking.addAFrenar(new Bicicleta());

        parking.executeArrencar();
        parking.executeAccelerar();
        parking.executeFrenar();

    }

}
