package n1e2;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

//https://stackoverflow.com/questions/1844688/how-to-read-all-files-in-a-folder-from-java
//https://forum.mendix.com/link/space/other/questions/250
//https://www.geeksforgeeks.org/how-to-sort-an-arraylist-of-objects-by-property-in-java/
public class FilesLoader {
    public static void loadFiles(String path, int depth) {
        ArrayList<FileData> files = new ArrayList<>();

        final File folder = new File(path);

        if (depth == 0)
            System.out.println("\nFolder examined: " + folder.getAbsolutePath() + "\n\nFiles:");

        DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:MM");

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

        for (FileData file : files) {

            System.out.println("-".repeat(depth) + "(" + file.type + ")" + file.name + " --> " + file.lastModification);
            if (file.type == 'D') {
                String folderPath = folder.getAbsolutePath() + "\\" + file.name;
                loadFiles(folderPath, depth + 1);
            }
        }
    }
}
