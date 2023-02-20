package n1e3;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

//https://www.w3schools.com/java/java_files_create.asp
//https://www.w3schools.com/java/java_files_read.asp
public class Main {
    private static HashMap<String, String> LoadCountriesAndCapitals(String filePath) {

        HashMap<String, String> countriesAndCapitals = new HashMap<String, String>();

        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] splitLine = line.split(" ");
                countriesAndCapitals.put(splitLine[0], splitLine[1]);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return countriesAndCapitals;
    }

    private static String GetUserName() {
        System.out.println("Insert your name: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private static byte StartGame(HashMap<String, String> countriesAndCapitals, byte numberOfQuestions) {

        List<String> countries = new ArrayList<>(countriesAndCapitals.keySet());

        //prevent array out of bounds
        if (numberOfQuestions > countries.size())
            numberOfQuestions = (byte) countries.size();


        System.out.println("For each country, insert its capital:\n");

        byte score = 0;
        Random rand = new Random();
        int randomPosition;
        String answ;
        Scanner scanner = new Scanner(System.in);

        for (byte i = 0; i < numberOfQuestions; i++) {
            randomPosition = rand.nextInt(countries.size());
            String countryToAsk = countries.get(randomPosition);
            //avoid repeating the country
            countries.remove(randomPosition);
            System.out.println(countryToAsk + ": ");
            answ = scanner.nextLine();

            if (answ.toLowerCase().equals(countriesAndCapitals.get(countryToAsk).toLowerCase()))
                score++;
        }
        return score;
    }

    private static void CreateClassificationFile(String filePath) {
        //Create a new file if it doesn't exist
        try {
            File file = new File(filePath);
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private static void SaveScoreToFile(String name, byte score, String filePath) {
        try {
            FileWriter fileWriter = new FileWriter(filePath, true);
            fileWriter.write(name + ": " + score + "\n");
            fileWriter.close();
            System.out.println("Score saved.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        String countriesPath = "resources/Countries.txt";
        String classificacioPath = "resources/classificacio.txt";

        HashMap<String, String> countriesAndCapitals = LoadCountriesAndCapitals(countriesPath);

        String name = GetUserName();

        //If desired, change the amount of questions
        byte score = StartGame(countriesAndCapitals, (byte)5);

        CreateClassificationFile(classificacioPath);
        SaveScoreToFile(name, score, classificacioPath);
    }
}
