package n2e2;

import java.util.ArrayList;

public class GenericMethods<T> {

    public GenericMethods(Persona t1, String t2, Integer t3) {
        list.add((T) t1);
        list.add((T) t2);
        list.add((T) t3);
    }

    private ArrayList<T> list = new ArrayList<>();

    ///region Getters and Setters
    public T getList(int index) {
        return list.get(index);
    }

    public void setList(T t) {
        list.add(t);
    }
    ///endregion

    public void printList() {
        for (T t : list) {
            System.out.println(t);
        }
    }


}
