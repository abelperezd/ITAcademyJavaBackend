package n2e1;

import java.util.ArrayList;

public class GenericMethods<T> {

    public GenericMethods(Persona t1, T t2, T t3) {
        list.add((T) t1);
        list.add(t2);
        list.add(t3);
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
