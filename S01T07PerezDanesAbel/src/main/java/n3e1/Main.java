package n3e1;

//Reflection: https://www.baeldung.com/java-get-field-annotations

@SuppressWarnings("deprecation")
public class Main {
    public static void main(String[] args) throws JsonSerializationException, Exception {

        Treballador treballador = new Treballador("Pau", "Martínez", 8);

        SerializeUtilities.serializeObject(treballador);

        Treballador deserializedTreballador = (Treballador) SerializeUtilities.deserializeObject(Treballador.class);

        System.out.println("Deserialized treballador: " + deserializedTreballador.getNom() + " " + deserializedTreballador.getCognom());
    }
}

