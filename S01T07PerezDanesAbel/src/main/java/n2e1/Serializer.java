package n2e1;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Serializer {
    public static void checkIfSerializable(Object object) throws JsonSerializationException {
        if (Objects.isNull(object)) {
            throw new JsonSerializationException("The object to serialize is null");
        }

        Class<?> class_ = object.getClass();
        if (!class_.isAnnotationPresent(JsonSerializable.class)) {
            throw new JsonSerializationException("The class "
                    + class_.getSimpleName()
                    + " is not annotated with JsonSerializable");
        }
    }

    public static String getJsonPath(Object object) {
        Class<?> class_ = object.getClass();
        return class_.getAnnotation(JsonSerializable.class).path();
    }
}
