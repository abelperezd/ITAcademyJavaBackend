package n3;

public class Avio implements IVehicleCommand {
    @Override
    public void arrencar() {
        System.out.println("L'avió ha arrencat els motors.");

    }

    @Override
    public void accelerar() {
        System.out.println("L'avió ha accelerat.");

    }

    @Override
    public void frenar() {
        System.out.println("L'avió ha frenat.");

    }
}
