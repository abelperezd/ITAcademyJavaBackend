package n1e3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

//https://stackoverflow.com/questions/1844688/how-to-read-all-files-in-a-folder-from-java
//https://forum.mendix.com/link/space/other/questions/250
//https://www.geeksforgeeks.org/how-to-sort-an-arraylist-of-objects-by-property-in-java/
//https://mkyong.com/java/java-how-to-get-current-date-time-date-and-calender/
public class FilesLoader {

    //To avoid it to change during the runtime
    final static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd_MM_yyyy__HH_mm_ss");
    final static String currentTime = formatter.format(LocalDateTime.now());

    public static void loadFiles(String path, int depth) {
        ArrayList<FileData> files = new ArrayList<>();

        final File folder = new File(path);

        if (depth == 0)
            System.out.println("\nFolder examined: " + folder.getAbsolutePath());

        final DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");

        try {
            for (final File fileEntry : folder.listFiles()) {

                String fileName = fileEntry.getName();

                char type = fileEntry.isDirectory() ? 'D' : 'F';

                String date = formatter.format(new Date(fileEntry.lastModified()));

                files.add(new FileData(fileName, type, date));
            }
        } catch (NullPointerException e) {

        }

        files.sort(FileData::compareTo);
        saveResult(files, depth, folder);
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

    private static void saveResult(ArrayList<FileData> files, int depth, File folder) {

        String filePath = "resources/result__" + currentTime + ".txt";

        createResultFile(filePath);

        for (FileData file : files) {
            FileWriter fileWriter = null;
            try {
                fileWriter = new FileWriter(filePath, true);
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }

            try {
                fileWriter.write("-".repeat(depth) + "(" + file.type + ")" + file.name + " --> " + file.lastModification + "\n");
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }

            //System.out.println("-".repeat(depth) + "(" + file.type + ")" + file.name + " --> " + file.lastModification);
            if (file.type == 'D') {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }
                String folderPath = folder.getAbsolutePath() + "\\" + file.name;
                loadFiles(folderPath, depth + 1);
            } else {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }
            }
        }


    }

}
