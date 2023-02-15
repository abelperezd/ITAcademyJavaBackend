package n1e1;
public class InstrumentDeVent extends Instrument {
    public InstrumentDeVent(String nom, float preu) {
        super(nom, preu);
    }

    @Override
    void tocar() {
        System.out.println("Està sonant un instrument de vent");
    }
}
