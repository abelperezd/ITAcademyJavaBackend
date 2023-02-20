package n1e2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String directory;
        if (args.length > 0)
            directory = args[0];
        else {
            System.out.println("Insert path to examine: ");
            Scanner scanner = new Scanner(System.in);
            directory = scanner.nextLine();
        }

        FilesLoader.loadFiles(directory, 0);

    }
}