package n3;

public class Vaixell implements IVehicleCommand {
    @Override
    public void arrencar() {
        System.out.println("El vaixell ha engegat els motors.");

    }

    @Override
    public void accelerar() {
        System.out.println("El vaixell ha accelerat.");

    }

    @Override
    public void frenar() {
        System.out.println("El vaixell ha frenat.");

    }
}
