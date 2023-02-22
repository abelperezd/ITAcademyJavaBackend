package n1e1;

public class Main {
    public static void main(String[] args) {

        Treballador treballador = new Treballador("Pau", "Martínez",8);
        TreballadorOnline treballadorOnline = new TreballadorOnline("Edu", "Gómez",5);
        TreballadorPresencial treballadorPresencial = new TreballadorPresencial("Eva", "Sánchez",15);

        System.out.println("Sou treballador: " + treballador.calcularSou(5));
        System.out.println("Sou treballador online: " + treballadorOnline.calcularSou(5));
        System.out.println("Sou treballador presencial: " + treballadorPresencial.calcularSou(5));
    }
}