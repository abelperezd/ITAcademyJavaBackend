package n3e1;

public class Generica {

    public <T extends Telefon> void utilitzarTelefon(T telefon) {
        telefon.trucar();

        if (telefon instanceof Smartphone)
            ((Smartphone) telefon).ferFotos();
    }

    public <T extends Smartphone> void utilitzarSmartphone(T smartphone) {
        smartphone.trucar();
        smartphone.ferFotos();
    }

}
