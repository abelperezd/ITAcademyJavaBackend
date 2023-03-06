package n2e1;

//Good video about annotations
//https://www.youtube.com/watch?v=DkZr7_c9ry8

//About serialization:
//https://www.baeldung.com/java-custom-annotation

import java.io.File;
import com.fasterxml.jackson.databind.ObjectMapper;

@SuppressWarnings("deprecation")
public class Main {
    public static void main(String[] args) throws JsonSerializationException, Exception {

        Treballador treballador = new Treballador("Pau", "Martínez", 8);

        ObjectMapper mapper = new ObjectMapper();

        Serializer.checkIfSerializable(treballador);

        String path = Serializer.getJsonPath(treballador);

        mapper.writeValue(new File(path  + "\\treballador.json"), treballador);

        Treballador deserializedTreballador = mapper.readValue(new File(path + "\\treballador.json"), Treballador.class);

        System.out.println("Deserialized treballador: " + deserializedTreballador.getNom() + " " + deserializedTreballador.getCognom());
    }
}

