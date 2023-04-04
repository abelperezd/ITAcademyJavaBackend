package n3e1;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;

public class PersistenceManager {

    ///region Save
    public static void encryptAndSaveData(Object object, String folderPath, String completePath, String key) {

        try {
            checkIfSerializable(object);
        } catch (JsonSerializationException e) {
        }

        String encrypted = Encrypter.encrypt(getJson(object), key);

        save(encrypted, folderPath, completePath);
    }

    private static <T> String getJson(Object object) {
        return new Gson().toJson(object);
    }

    private static void save(String data, String folderPath, String completePath) {
        createResultFile(folderPath);

        try {
            FileWriter fileWriter = new FileWriter(completePath, false);
            fileWriter.write(data);
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    private static void createResultFile(String filePath) {
        //Create a new file if it doesn't exist
        try {
            File file = new File(filePath);
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                //System.out.println("File already exists.");
            }
        } catch (
                IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    private static void checkIfSerializable(Object object) throws JsonSerializationException {
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

    //endregion

    //region load

    public static <T> T loadEncryptedData(Class<T> objectType, String path, String key) {
        String decrypted = Encrypter.decrypt(readFilesInTxt(path), key);
        return new Gson().fromJson(decrypted, objectType);
    }

    private static String readFilesInTxt(String filePath) {
        try {
            return new String(Files.readAllBytes(Paths.get(filePath)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //endregion
}
