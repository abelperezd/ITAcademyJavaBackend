package n1e2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://www.youtube.com/watch?v=a450CqNXFgs
//https://www.youtube.com/watch?v=tj5sLSFjVj4
//https://www.youtube.com/watch?v=j6yY5ZRYJyI&list=PLjJ8HhsSfskiDEwgfyF9EznmrSyEukcJa&index=5

public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("casa", "portar", "peu", "dinar", "sopar", "dos", "tres", "blau", "groc", "tovallola", "gos", "gossos"));

        int maxWordLengthAllowed = 5;

        list.removeIf(s -> !(s.contains("o") && s.length() > maxWordLengthAllowed));

        list.forEach(s -> System.out.println(s));
    }
}