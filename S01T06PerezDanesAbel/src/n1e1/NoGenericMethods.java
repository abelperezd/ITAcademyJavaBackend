package n1e1;

import java.util.ArrayList;

public class NoGenericMethods {
    private ArrayList<NoGenericObject> objects = new ArrayList<>();

    public NoGenericMethods(NoGenericObject o1, NoGenericObject o2, NoGenericObject o3) {
        objects.add(o1);
        objects.add(o2);
        objects.add(o3);
    }

    //region Getters and setters
    public NoGenericObject getObject(int index) {
        return objects.get(index);
    }

    public void setObject(NoGenericObject object) {
        objects.add(object);
    }
    //endregion

}
