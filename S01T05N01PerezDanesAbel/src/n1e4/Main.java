package n1e4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        boolean validOption = false;
        boolean validPath = false;

        // 0-> create file with directories / 1-> read directories from file
        int option = 0;
        String directory = null;

        if (args.length > 0) {
            try {
                option = Integer.parseInt(args[0]);
                validOption = true;
            } catch (NumberFormatException e) {
                System.out.println(e);
                System.out.println("Invalid option");
            }
            if (args.length > 1) {
                directory = args[1];
                validPath = true;
            }
        }

        Scanner scanner = new Scanner(System.in);

        if (!validOption) {
            System.out.println("0: save directories in file / 1: read directories from file. \nInsert option: ");
            try {
                option = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println(e);
                System.out.println("Invalid option");
                return;
            }
        }

        if (!validPath) {
            System.out.println("Insert path to examine (e.g. result__18_02_2023__14_02_04.txt, in resources): ");
            directory = scanner.nextLine();
        }

        if (option == 0)
            FilesLoader.loadFiles(directory, 0);
        else if (option == 1)
            FilesLoader.readFilesInTxt(directory);
    }
}