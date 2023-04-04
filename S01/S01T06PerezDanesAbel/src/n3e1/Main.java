package n3e1;


public class Main {
    public static void main(String[] args) {
        Smartphone smartphone = new Smartphone();
        Generica generica = new Generica();
        generica.utilitzarSmartphone(smartphone);
        generica.utilitzarTelefon(smartphone);
    }
}