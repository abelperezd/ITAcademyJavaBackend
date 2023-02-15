package n1e1;
public abstract class Instrument {
    {
        System.out.println("S'ha creat una instància d'un objecte que hereda d'Instrument");
    }

    static
    {
        System.out.println("La classe instrument ha carregat");
    }
    public static String demostracioMembreEstatic = "Accès a un membre estàtic de la classe";

    public Instrument(String nom, float preu){
        this.nom = nom;
        this.preu = preu;
    }

    protected String nom;
    protected float preu;

    abstract void tocar();
}
