package n3e1;

import java.util.ArrayList;

//https://www.tutorialspoint.com/java/java_serialization.htm

@JsonSerializable
public class SerializableFileData implements java.io.Serializable
{
    public ArrayList<String> files = new ArrayList<>();

}
