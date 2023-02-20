package n1e1;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        System.out.println();

        ArrayList<Month> monthsList = new ArrayList<>(Arrays.asList(new Month("Gener"), new Month("Febrer"), new Month("Març"),
                new Month("Abril"), new Month("Maig"), new Month("Juny"), new Month("Juliol"),
                new Month("Septembre"), new Month("Octubre"), new Month("Novembre"), new Month("Decembre")));

        monthsList.add(7, new Month("Agost"));

        System.out.println("Using for: ");
        for (Month m : monthsList) {
            System.out.println(m.getName());
        }

        System.out.println();

        System.out.println("Using iterator: ");
        Iterator<Month> it = monthsList.iterator();
        while(it.hasNext()) {
            System.out.println(it.next().getName());
        }

        HashSet<Month> monthHashSet = new HashSet<>(monthsList);
        //To be sure it doesn't admit duplicates
        monthsList.add(new Month("Novembre"));

        System.out.println();

        System.out.println("Hash set: ");
        it = monthHashSet.iterator();
        while(it.hasNext()) {
            System.out.println(it.next().getName());
        }
    }
}