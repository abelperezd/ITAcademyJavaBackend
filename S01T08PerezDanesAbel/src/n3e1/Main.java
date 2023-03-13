package n3e1;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ArrayList<Alumne> list = new ArrayList<>(Arrays.asList(
                new Alumne("Pau", 12, Curs.Java, 7.02f),
                new Alumne("Arnau", 18, Curs.PHP, 9.12f),
                new Alumne("Jana", 22, Curs.Java, 6.2f),
                new Alumne("Edu", 22, Curs.Unity, 4.1f),
                new Alumne("Aina", 12, Curs.Node, 3.71f),
                new Alumne("Rosana", 17, Curs.Python, 4.95f),
                new Alumne("David", 18, Curs.Node, 6.2f),
                new Alumne("Julia", 15, Curs.Java, 5.1f),
                new Alumne("Abel", 23, Curs.Java, 7.1f),
                new Alumne("Anna", 13, Curs.PHP, 2.75f)));

        Alumne.printTotsElsAlumnes(list);
        Alumne.printTotsElsAlumnesQueComencenPerA(list);
        Alumne.printTotsElsAlumnesAprovats(list);
        Alumne.printAlumnesAprovatsNoDePHP(list);
        Alumne.printTotsElsAlumnesMajorsDeJava(list);
    }


}