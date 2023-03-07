package n2e1;

//https://www.youtube.com/watch?v=a450CqNXFgs
//https://www.youtube.com/watch?v=tj5sLSFjVj4
//https://www.youtube.com/watch?v=j6yY5ZRYJyI&list=PLjJ8HhsSfskiDEwgfyF9EznmrSyEukcJa&index=5

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>(Arrays.asList("Abel", "Maria", "Jesus", "Rosa", "Ivet", "Estela", "Uri", "Ana", "Ari", "Ale", "ana", "Arnau"));
        list.removeIf(s -> !(s.startsWith("A") && s.length() == 3));
        list.forEach(s -> System.out.println(s));
    }
}