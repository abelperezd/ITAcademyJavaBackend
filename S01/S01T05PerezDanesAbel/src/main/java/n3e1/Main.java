package n3e1;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//https://www.youtube.com/watch?v=bFXJUbaCb5g

public class Main {
    public static void main(String[] args) {

        Props properties = readProperties();

        //Do file search
        SerializableFileData serializable = new SerializableFileData();
        FilesLoader.startSearch(properties.directoryToRead, serializable);

        //Encrypt and save data
        PersistenceManager.encryptAndSaveData(serializable, properties.resultPathWithoutName, properties.completeResultPath, "testPassword1234");

        //Decrypt and print recovered data
        SerializableFileData decryptedData = PersistenceManager.loadEncryptedData(SerializableFileData.class, properties.completeResultPath, "testPassword1234");
        decryptedData.files.forEach(System.out::println);
    }

    private static Props readProperties() {
        Properties properties = new Properties();

        Props props = new Props();

        InputStream input;

        try {
            input = new FileInputStream("prop.properties");
            properties.load(input);
            props.directoryToRead = properties.getProperty("pathToRead");
            props.resultPathWithoutName = properties.getProperty("resultPath");
            props.resultFileName = properties.getProperty("resultName");
        } catch (IOException e) {
            e.printStackTrace();
        }
        props.completeResultPath = props.resultPathWithoutName + "/" + props.resultFileName + ".txt";

        return props;
    }
}