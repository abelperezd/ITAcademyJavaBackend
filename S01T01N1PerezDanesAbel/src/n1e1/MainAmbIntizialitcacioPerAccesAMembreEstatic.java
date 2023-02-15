package n1e1;
public class MainAmbIntizialitcacioPerAccesAMembreEstatic {
    /*
    * Amb aquesta execució demostrem que la classe Instrument pot ser carregada en cridar
    * un membre estàtic de la classe, i que només es carrega una vegada.
    * */
    public static void main(String[] args) {

        System.out.println(Instrument.demostracioMembreEstatic);
        System.out.println("Hem carregat la classe accedint a un membre estàtic");

        InstrumentDeCorda guitarra = new InstrumentDeCorda("guitarra", 150);
        guitarra.tocar();

        InstrumentDeVent flauta = new InstrumentDeVent("flauta", 10);
        flauta.tocar();

        InstrumentDePercussio tambor = new InstrumentDePercussio("tambor", 25);
        tambor.tocar();
    }
}