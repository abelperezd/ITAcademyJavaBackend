package n1e2;

import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));

        List<Integer> integersReversed = new LinkedList<>();

        ListIterator<Integer> listIterator = integers.listIterator();
        while (listIterator.hasNext()) {
            integersReversed.add(0, listIterator.next());
        }
        for (Integer i : integersReversed) {
            System.out.println(i);
        }
    }
}
