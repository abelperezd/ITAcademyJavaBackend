package n1e6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//https://www.youtube.com/watch?v=a450CqNXFgs
//https://www.youtube.com/watch?v=tj5sLSFjVj4
//https://www.youtube.com/watch?v=j6yY5ZRYJyI&list=PLjJ8HhsSfskiDEwgfyF9EznmrSyEukcJa&index=5

public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("a", "bb", "dddd", "ccc", "ffffff", "eee", "cadena llarga", "g", "hh"));

        list.sort(Comparator.comparingInt(String::length));

        list.forEach(s -> System.out.println(s));
    }
}