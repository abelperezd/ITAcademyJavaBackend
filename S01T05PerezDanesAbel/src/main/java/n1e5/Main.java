package n1e5;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        boolean validPath = false;

        String directory = null;

        if (args.length > 0) {
            directory = args[0];
            validPath = true;
        }

        if (!validPath) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Insert path to examine: ");
            directory = scanner.nextLine();
        }

        SerializableFileData serializableFileData = new SerializableFileData();

        FilesLoader.loadFiles(directory, serializableFileData.files, 0);
        try {
            FileOutputStream fileOut = null;
            fileOut = new FileOutputStream("/tmp/result.ser");
            ObjectOutputStream out = null;
            out = new ObjectOutputStream(fileOut);
            out.writeObject(serializableFileData);
            out.close();
            fileOut.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            FileInputStream fileIn = new FileInputStream("/tmp/result.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            SerializableFileData deserializedFileData = (SerializableFileData) in.readObject();
            in.close();
            fileIn.close();
            FilesLoader.printFiles(serializableFileData.files);
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Employee class not found");
            c.printStackTrace();
        }

    }
}