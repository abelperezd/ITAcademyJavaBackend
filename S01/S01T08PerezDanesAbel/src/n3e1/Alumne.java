package n3e1;

import java.util.ArrayList;

public class Alumne {

    //region Attributes

    private String nom;
    private int edat;
    private Curs curs;
    private float nota;

    //endregion

    //region Constructor and getters

    public Alumne(String nom, int edat, Curs curs, float nota) {
        this.nom = nom;
        this.edat = edat;
        this.curs = curs;
        this.nota = nota;
    }

    public String getNom() {
        return nom;
    }

    public int getEdat() {
        return edat;
    }

    public Curs getCurs() {
        return curs;
    }

    public float getNota() {
        return nota;
    }

    //endregion

    //region Filtered prints

    public static void printTotsElsAlumnes(ArrayList<Alumne> list) {
        System.out.println("\nTots els alumnes:");
        System.out.printf("%-10s %-10s\n", "NOM", "EDAT");
        list.forEach(a -> System.out.printf("%-10s %-10d\n", a.getNom(), a.getEdat()));
    }

    public static void printTotsElsAlumnesQueComencenPerA(ArrayList<Alumne> list) {
        System.out.println("\nAlumnes que comencen per 'a':");
        ArrayList<Alumne> auxList = new ArrayList<>(list);
        auxList.removeIf(a -> !a.getNom().toLowerCase().startsWith("a"));
        printAlumnesDataHeader();
        auxList.forEach(Alumne::printAlumeData);
    }

    public static void printTotsElsAlumnesAprovats(ArrayList<Alumne> list) {
        System.out.println("\nAlumnes aprovats:");
        printAlumnesDataHeader();
        list.forEach(a -> {
            if (a.getNota() >= 5)
                printAlumeData(a);
        });
    }

    public static void printAlumnesAprovatsNoDePHP(ArrayList<Alumne> list) {
        System.out.println("\nAlumnes aprovats i que no són de PHP:");
        printAlumnesDataHeader();
        list.forEach(a -> {
            if (a.getNota() >= 5 && a.getCurs() != Curs.PHP)
                printAlumeData(a);
        });
    }

    public static void printTotsElsAlumnesMajorsDeJava(ArrayList<Alumne> list) {
        System.out.println("\nAlumnes de JAVA majors d'edat:");
        printAlumnesDataHeader();
        list.forEach(a -> {
            if (a.getEdat() >= 18 && a.getCurs() == Curs.Java)
                printAlumeData(a);
        });
    }

    private static void printAlumnesDataHeader() {
        System.out.printf("%-10s %-10s %-10s %-10s \n", "NOM", "EDAT", "CURS", "NOTA");
    }

    private static void printAlumeData(Alumne a) {
        System.out.printf("%-10s %-10d %-10s %-10.2f \n", a.getNom(), a.getEdat(), a.getCurs(), a.getNota());
    }

    //endregion

}


