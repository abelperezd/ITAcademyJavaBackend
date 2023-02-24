package n1e8;

//https://www.youtube.com/watch?v=a450CqNXFgs
//https://www.youtube.com/watch?v=tj5sLSFjVj4
//https://www.youtube.com/watch?v=j6yY5ZRYJyI&list=PLjJ8HhsSfskiDEwgfyF9EznmrSyEukcJa&index=5

public class Main {
    public static void main(String[] args) {
        String test = "abcdefg";
        Reversible reversible = s -> String.valueOf(new StringBuilder(s).reverse());
        System.out.println(reversible.reverse(test));
    }
}