package n2e1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//https://www.youtube.com/watch?v=bFXJUbaCb5g

public class Main {
    public static void main(String[] args) {

        Properties properties = new Properties();

        InputStream input;

        String directory = null;
        String resultFileName = null;
        String resultPath = null;

        try {
            input = new FileInputStream("prop.properties");
            properties.load(input);
            directory = properties.getProperty("pathToRead");
            resultPath = properties.getProperty("resultPath");
            resultFileName = properties.getProperty("resultName");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        FilesLoader.setProperties(resultFileName, resultPath);
        FilesLoader.loadFiles(directory, 0);
    }
}