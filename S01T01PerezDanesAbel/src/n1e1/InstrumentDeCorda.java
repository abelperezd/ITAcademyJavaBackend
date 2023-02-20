package n1e1;
public class InstrumentDeCorda extends Instrument {
    public InstrumentDeCorda(String nom, float preu) {
        super(nom, preu);
    }

    @Override
    void tocar() {
        System.out.println("Està sonant un instrument de corda");
    }
}
