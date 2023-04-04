package n1e1;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

//https://stackoverflow.com/questions/1844688/how-to-read-all-files-in-a-folder-from-java
public class FilesLoader {
    public static void loadFiles(String path) {

        ArrayList<String> files = new ArrayList<>();
        final File folder = new File(path);

        System.out.println("\nFolder examined: " + folder.getAbsolutePath() + "\n\nFiles:");

        for (final File fileEntry : folder.listFiles()) {
            if (!fileEntry.isDirectory()) {
                files.add(fileEntry.getName());
            }
        }

        Collections.sort(files,String.CASE_INSENSITIVE_ORDER);

        for (String name : files) {
            System.out.println("-" + name);
        }

        System.out.println("\nFiles found: " + files.size());
    }

}
