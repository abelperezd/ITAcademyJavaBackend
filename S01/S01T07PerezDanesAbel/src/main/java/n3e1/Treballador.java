package n3e1;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class Treballador {

    //region Attributes

    @JsonElement
    protected String nom;
    @JsonElement
    protected String cognom;
    @JsonElement
    protected int preu_hora;

    //endregion

    //region Constructors and Getters

    public Treballador() {
    }

    public Treballador(String nom, String cognom, int preu_hora) {
        this.nom = nom;
        this.cognom = cognom;
        this.preu_hora = preu_hora;
    }

    public String getNom() {
        return nom;
    }

    public String getCognom() {
        return cognom;
    }

    public int getPreu_hora() {
        return preu_hora;
    }

    //endregion

    //region Serialization and Deserialization

    //Called from Reflection
    @JsonSerializableMethod(path = "C:\\Users\\apere\\Desktop\\Proyectos\\ITAcademyJavaBackend\\S01T07PerezDanesAbel")
    public void serialize() {
        try {
            new ObjectMapper().writeValue(new File(SerializeUtilities.getJsonPath(this) + "\\treballador.json"), this);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (JsonSerializationException e) {
        }
    }

    //Called from Reflection
    @JsonDeserializableMethod(path = "C:\\Users\\apere\\Desktop\\Proyectos\\ITAcademyJavaBackend\\S01T07PerezDanesAbel")
    public static Treballador deserialize() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(new File(SerializeUtilities.getJsonPath(Treballador.class) + "\\treballador.json"), Treballador.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (JsonSerializationException e) {
        }
        return null;
    }

    //endregion

}
