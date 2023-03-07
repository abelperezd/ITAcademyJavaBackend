package n2e2;

//https://www.youtube.com/watch?v=a450CqNXFgs
//https://www.youtube.com/watch?v=tj5sLSFjVj4
//https://www.youtube.com/watch?v=j6yY5ZRYJyI&list=PLjJ8HhsSfskiDEwgfyF9EznmrSyEukcJa&index=5

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(3, 5, 44));
        System.out.println(stringFormatter(list));
    }

    private static String stringFormatter(ArrayList<Integer> list) {
        String result = "";
        for (int i : list) {
            if ((i % 2) == 0)
                result += "e" + i + ",";
            else
                result += "o" + i + ",";
        }

        result = result.substring(0, result.length() - 1);
        return result;
    }
}