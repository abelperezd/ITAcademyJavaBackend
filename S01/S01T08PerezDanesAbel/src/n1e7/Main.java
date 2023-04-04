package n1e7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://www.youtube.com/watch?v=a450CqNXFgs
//https://www.youtube.com/watch?v=tj5sLSFjVj4
//https://www.youtube.com/watch?v=j6yY5ZRYJyI&list=PLjJ8HhsSfskiDEwgfyF9EznmrSyEukcJa&index=5

public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("a", "bb", "dddd", "ccc", "ffffff", "eee", "cadena llarga", "g", "hh"));

        list.sort((s1, s2) -> Integer.compare(s2.length(),s1.length()));

        list.forEach(s -> System.out.println(s));
    }
}