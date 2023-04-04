package n2e4;

//https://www.youtube.com/watch?v=a450CqNXFgs
//https://www.youtube.com/watch?v=tj5sLSFjVj4
//https://www.youtube.com/watch?v=j6yY5ZRYJyI&list=PLjJ8HhsSfskiDEwgfyF9EznmrSyEukcJa&index=5

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>(Arrays.asList("Abel", "7", "Maria a la botiga", "rosa", "94", "7.2", "arbre", "uri", "ana", "peu"));

        System.out.println("Alfabèticament pel primer caràcter:");
        list.sort(Comparator.comparing(s -> String.valueOf(s.charAt(0)).toLowerCase(Locale.ROOT)));
        list.forEach(s -> System.out.println(s));
        System.out.println();

        System.out.println("Les cadenes que contenen una \"e\" primer, la resta de cadenes després:");
        list.sort((s1, s2) -> {
            if (s1.contains("e"))
                return -1;
            if (s2.contains("e"))
                return 1;
            return 0;
        });
        list.forEach(s -> System.out.println(s));
        System.out.println();

        System.out.println("Modifica tots els elements de la llista que tenen una ‘a’. Modifica la ‘a’ per un ‘4’:");
        list.replaceAll(s -> s.replaceAll("a", "4"));
        list.forEach(s -> System.out.println(s));
        System.out.println();

        System.out.println("Mostra només els elements que són numèrics:");
        list.removeIf(s -> {
            try {
                Integer.parseInt(s);
                return false;
            } catch (NumberFormatException e) {
            }

            try {
                Float.parseFloat(s);
                return false;
            } catch (NumberFormatException e) {
            }
            return true;
        });
        list.forEach(s -> System.out.println(s));
    }
}