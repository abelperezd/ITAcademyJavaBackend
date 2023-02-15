package n1e1;
public class MainAmbIntizialitcacioPerInstancia {
    /*
    * Amb aquesta execució demostrem que la classe Instrument pot ser carregada en instanciar
    * la primera classe d'aquest tipus, i que només es crida una vegada.
    * */
    public static void main(String[] args) {

        InstrumentDeCorda guitarra = new InstrumentDeCorda("guitarra", 150);
        guitarra.tocar();

        InstrumentDeVent flauta = new InstrumentDeVent("flauta", 10);
        flauta.tocar();

        InstrumentDePercussio tambor = new InstrumentDePercussio("tambor", 25);
        tambor.tocar();
    }
}