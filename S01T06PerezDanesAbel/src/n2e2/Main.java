package n2e2;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Object> list = new ArrayList<Object>();
        GenericMethods gm = new GenericMethods<>(new Persona("aa", "bb", 1), "This is a String", 8, 7.4, 'a');
        gm.printList();
    }
}