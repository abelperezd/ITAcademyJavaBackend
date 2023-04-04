package n1e2;

public class Treballador {
    public Treballador(String nom, String cognom, int preu_hora) {
        this.nom = nom;
        this.cognom = cognom;
        this.preu_hora = preu_hora;
    }
    protected String nom;
    protected String cognom;
    protected int preu_hora;


    ///region Getters and Setters
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCognom() {
        return cognom;
    }

    public void setCognom(String cognom) {
        this.cognom = cognom;
    }

    public int getPreu_hora() {
        return preu_hora;
    }
    public void setPreu_hora(int preu_hora) {
        this.preu_hora = preu_hora;
    }
    ///endregion

    public int calcularSou(int horesTreballades){
        return horesTreballades * preu_hora;
    }

}
