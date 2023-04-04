package n2e2;

import java.util.ArrayList;

//https://lineadecodigo.com/java/parametros-variables-en-java/
//https://desarrolloavanzado.com/parametros-variables-en-java-vararg-parameters/

public class GenericMethods<T> {

    private ArrayList<T> list = new ArrayList<>();

    public GenericMethods(T... list) {
        for (T t : list) {
            this.list.add(t);
        }
    }

    ///region Getters and Setters
    public T getList(int index) {
        return list.get(index);
    }

    public void setList(T t) {
        list.add(t);
    }
    ///endregion

    public void printList() {
        list.forEach(System.out::println);
    }


}
