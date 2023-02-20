package n1e5;

import java.io.File;
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
    final static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd_MM_yyyy__HH_MM_ss");

    public static void loadFiles(String path, ArrayList<String> serializableFileData, int depth) {
        ArrayList<FileData> files = new ArrayList<>();

        final File folder = new File(path);

        if (depth == 0)
            System.out.println("\nFolder examined: " + folder.getAbsolutePath());

        final DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:MM");

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
        saveResult(files, serializableFileData, depth, folder);
    }


    private static void saveResult(ArrayList<FileData> files, ArrayList<String> serializableFileData, int depth, File folder) {

        for (FileData file : files) {
            serializableFileData.add("-".repeat(depth) + "(" + file.type + ")" + file.name + " --> " + file.lastModification);

            //System.out.println("-".repeat(depth) + "(" + file.type + ")" + file.name + " --> " + file.lastModification);
            if (file.type == 'D') {
                String folderPath = folder.getAbsolutePath() + "\\" + file.name;
                loadFiles(folderPath, serializableFileData, depth + 1);
            }
        }
    }

    public static void printFiles(ArrayList<String> files) {

        for (String line : files
        ) {
            System.out.println(line);
        }
    }
}
