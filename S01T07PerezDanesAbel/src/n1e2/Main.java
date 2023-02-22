package n1e2;

//Good video about annotations
//https://www.youtube.com/watch?v=DkZr7_c9ry8

//About serialization:
//https://www.baeldung.com/java-custom-annotation

public class Main {
    public static void main(String[] args) {

        Treballador treballador = new Treballador("Pau", "Martínez",8);
        TreballadorOnline treballadorOnline = new TreballadorOnline("Edu", "Gómez",5);
        TreballadorPresencial treballadorPresencial = new TreballadorPresencial("Eva", "Sánchez",15);

        System.out.println("Sou treballador: " + treballador.calcularSou(5));
        System.out.println("Sou treballador online: " + treballadorOnline.calcularSou(5));
        System.out.println("Sou treballador presencial: " + treballadorPresencial.calcularSou(5));

        
        System.out.println("Sou diari treballador online: " +  treballadorOnline.calcularSouDiari(2));
        System.out.println("Sou diari treballador presencial: " + treballadorPresencial.calcularSouDiari(2));
    }
}