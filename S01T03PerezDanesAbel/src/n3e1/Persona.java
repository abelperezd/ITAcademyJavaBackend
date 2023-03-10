package n3e1;

public class Persona {

    ///region attributes

    private String nom;
    private String cognom;
    private String DNI;

    ///endregion

    ///region Constructor and getters
    public Persona(String nom, String cognom, String DNI) {
        this.nom = nom;
        this.cognom = cognom;
        this.DNI = DNI;
    }
    public String getNom() {
        return nom;
    }

    public String getCognom() {
        return cognom;
    }

    public String getDNI() {
        return DNI;
    }
    ///endregion
}
