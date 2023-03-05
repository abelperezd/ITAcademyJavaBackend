package n2e2;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Object> list = new ArrayList<Object>();
        list.add(new Persona("aa", "bb", 1));
        list.add("This is a String");
        list.add(8);
        GenericMethods gm = new GenericMethods<>(list);
        gm.printList();
    }
}