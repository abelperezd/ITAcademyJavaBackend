package n3;

public class Cotxe implements IVehicleCommand {
    @Override
    public void arrencar() {
        System.out.println("El cotxe ha arrencat.");

    }

    @Override
    public void accelerar() {
        System.out.println("El cotxe ha accelerat.");

    }

    @Override
    public void frenar() {
        System.out.println("El cotxe ha frenat.");

    }
}
