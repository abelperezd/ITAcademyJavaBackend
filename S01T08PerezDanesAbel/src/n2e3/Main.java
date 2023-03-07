package n2e3;

//https://www.youtube.com/watch?v=a450CqNXFgs
//https://www.youtube.com/watch?v=tj5sLSFjVj4
//https://www.youtube.com/watch?v=j6yY5ZRYJyI&list=PLjJ8HhsSfskiDEwgfyF9EznmrSyEukcJa&index=5

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(3, 5, 44));

        Operator suma = (a,b) -> a  + b;
        Operator resta = (a,b) -> a  - b;
        Operator multiplicacio = (a,b) -> a  * b;
        Operator divisio = (a,b) -> a  / b;

        System.out.println("suma: " + suma.operacio(5,3));
        System.out.println("resta: " + resta.operacio(5,3));
        System.out.println("multiplicacio: " + multiplicacio.operacio(5,3));
        System.out.println("divisio: " + divisio.operacio(5,3));
    }
}