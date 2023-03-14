package n3e1;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class SerializeUtilities {

    //region Path getters

    public static String getJsonPath(Object object) throws JsonSerializationException {
        return getJsonPath(object.getClass());
    }

    public static String getJsonPath(Class class_) throws JsonSerializationException {
        try {
            Annotation a = class_.getDeclaredMethod("serialize").getAnnotation(JsonSerializableMethod.class);
            return ((JsonSerializableMethod) a).path();
        } catch (NoSuchMethodException e) {
            throw new JsonSerializationException("The class "
                    + class_.getSimpleName()
                    + " is not annotated with JsonSerializable");
        }
    }

    //endregion

    //region Serialization and Deserialization

    public static void serializeObject(Object object) {
        Method[] methods = object.getClass().getDeclaredMethods();
        for (Method m : methods) {
            Annotation a = m.getAnnotation(JsonSerializableMethod.class);
            if (a != null) {
                try {
                    m.setAccessible(true);
                    m.invoke(object);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public static Object deserializeObject(Class class_) {
        Method[] methods = class_.getDeclaredMethods();
        for (Method m : methods) {
            Annotation a = m.getAnnotation(JsonDeserializableMethod.class);
            if (a != null) {
                try {
                    m.setAccessible(true);
                    return m.invoke(class_);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return null;
    }

    //endregion
}
