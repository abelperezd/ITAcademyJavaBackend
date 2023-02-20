package n1e3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Numbers {
    private static ArrayList<Integer> numbers = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6));
    public static ArrayList<Integer> getSomeNumbers(int amount) {
        ArrayList<Integer> numbersToGet = null;
        try {
            numbersToGet = (ArrayList<Integer>) numbers.subList(0, amount);
        } catch (IndexOutOfBoundsException e) {
            throw  e;

        }
        return numbersToGet;
    }
}
