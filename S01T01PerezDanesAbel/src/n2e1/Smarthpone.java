package n2e1;

public class Smarthpone extends Telefon implements Camera, Rellotge {

    public Smarthpone(String marca, String model) {
        super(marca, model);
    }

    @Override
    public void fotografiar() {
        System.out.println("Taking photo");
    }

    @Override
    public void alarma() {
        System.out.println("Alarm ringing");
    }
}
