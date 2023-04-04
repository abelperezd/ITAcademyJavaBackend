package n3e1;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


//https://stackoverflow.com/questions/1844688/how-to-read-all-files-in-a-folder-from-java
//https://forum.mendix.com/link/space/other/questions/250
//https://www.geeksforgeeks.org/how-to-sort-an-arraylist-of-objects-by-property-in-java/
//https://mkyong.com/java/java-how-to-get-current-date-time-date-and-calender/
public class FilesLoader {

    public static void startSearch(String directory, SerializableFileData serializable) {
        loadFiles(directory, 0, serializable);
    }

    public static void loadFiles(String path, int depth, SerializableFileData serializable) {

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
            e.printStackTrace();
        }

        files.sort(FileData::compareTo);
        saveResultAndContinueSearch(files, depth, folder, serializable);
    }

    private static void saveResultAndContinueSearch(ArrayList<FileData> files, int depth, File folder, SerializableFileData serializable) {
        for (FileData file : files) {

            serializable.files.add("-".repeat(depth) + "(" + file.type + ")" + file.name + " --> " + file.lastModification);

            if (file.type == 'D') {
                String folderPath = folder.getAbsolutePath() + "\\" + file.name;
                loadFiles(folderPath, depth + 1, serializable);
            }
        }
    }
}
