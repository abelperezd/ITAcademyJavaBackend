package n3e1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

//https://www.youtube.com/watch?v=zKDmzKaAQro
public class Main {
    private enum Order {
        nomAZ, nomZA, CognomAZ, cognomZA, DNI19, DNIZ91
    }

    private static final Scanner scanner = new Scanner(System.in);

    private static ArrayList<Persona> readPeopleList(String filePath) {
        ArrayList<Persona> personaList = new ArrayList<>();

        BufferedReader reader = null;

        String line = "";

        boolean isFirstLine = true;

        try {
            reader = new BufferedReader(new FileReader(filePath));
            while ((line = reader.readLine()) != null) {

                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }

                String[] row = line.split(";");
                personaList.add(new Persona(row[0], row[1], row[2]));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return personaList;
    }

    public static void main(String[] args) {
        ArrayList<Persona> list = readPeopleList("src\\alumnes.csv");

        showMenu(list);

        scanner.close();
    }

    private static void showMenu(ArrayList<Persona> list) {
        System.out.println("1.- Introduir persona.");
        System.out.println("2.- Mostrar les persones ordenades per nom (A-Z).");
        System.out.println("3.- Mostrar les persones ordenades per nom (Z-A).");
        System.out.println("4.- Mostrar les persones ordenades per cognoms (A-Z).");
        System.out.println("5.- Mostrar les persones ordenades per cognoms (Z-A).");
        System.out.println("6.- Mostrar les persones ordenades per DNI (1-9).");
        System.out.println("7.- Mostrar les persones ordenades per DNI (9-1).");
        System.out.println("0.- Sortir.\n");

        int input = 0;
        try {
            input = scanner.nextInt();
            scanner.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Wrong input, try again.\n");
            showMenu(list);
        }

        switch (input) {
            case 1:
                introduirPersona(list);
                break;
            case 2, 3, 4, 5, 6,7:
                mostrarPersonesOrdenades(list, Order.values()[input - 2]);
            case 0:
                return;
            default:
                System.out.println("Wrong input, try again.\n");
                showMenu(list);
        }
    }

    private static void introduirPersona(ArrayList<Persona> list) {
        System.out.println("Nom: ");

        String nom = scanner.nextLine();
        System.out.println("Cogoms: ");

        String cognom = scanner.nextLine();
        System.out.println("DNI: ");

        String dni = scanner.nextLine();
        list.add(new Persona(nom, cognom, dni));

        showMenu(list);
    }

    private static void mostrarPersonesOrdenades(ArrayList<Persona> list, Order o) {
        switch (o) {
            case nomAZ -> list.sort(Comparator.comparing(Persona::getNom));
            case nomZA -> list.sort((p1, p2) -> p2.getNom().compareTo(p1.getNom()));
            case CognomAZ -> list.sort(Comparator.comparing(Persona::getCognom));
            case cognomZA -> list.sort((p1, p2) -> p2.getCognom().compareTo(p1.getCognom()));
            case DNI19 -> list.sort(Comparator.comparing(Persona::getDNI));
            case DNIZ91 -> list.sort((p1, p2) -> p2.getDNI().compareTo(p1.getDNI()));
        }

        System.out.printf("%-10s%-20s%-10s\n", "Nom", "Cognom", "DNI");
        list.forEach(p -> System.out.printf("%-10s%-20s%-10s\n", p.getNom(), p.getCognom(), p.getDNI()));

        System.out.println("\nInsert any key to continue...");
        scanner.nextLine();

        showMenu(list);
    }


}
