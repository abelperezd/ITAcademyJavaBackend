package n2e2;

public class Main {
    public static void main(String[] args) {

        GenericMethods gm = new GenericMethods<>(new Persona("aa", "bb", 1), "This is a String", 8);
        gm.printList();

    }
}