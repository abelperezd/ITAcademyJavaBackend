package n2e1;

import n1e1.Producte;
import n1e1.Venda;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static byte llegirByte(String missatge) throws Entrada {
        System.out.println(missatge);
        while (true) {
            try {
                byte b = scanner.nextByte();
                return b;
            } catch (InputMismatchException e) {
                scanner.nextLine(); // consume the invalid input
                System.out.println(new Entrada().getMessage());
                System.out.println("Try again:");
            }
        }
    }

    public static int llegirInt(String missatge) {
        System.out.println(missatge);
        while (true) {
            try {
                int i = scanner.nextInt();
                return i;
            } catch (InputMismatchException e) {
                scanner.nextLine(); // consume the invalid input
                System.out.println(new Entrada().getMessage());
                System.out.println("Try again:");
            }
        }
    }

    public static float llegirFloat(String missatge) {
        System.out.println(missatge);
        while (true) {
            try {
                float f = scanner.nextFloat();
                return f;
            } catch (InputMismatchException e) {
                scanner.nextLine(); // consume the invalid input
                System.out.println(new Entrada().getMessage());
                System.out.println("Try again:");
            }
        }
    }

    public static double llegirDouble(String missatge) {
        System.out.println(missatge);
        while (true) {
            try {
                double d = scanner.nextDouble();
                return d;
            } catch (InputMismatchException e) {
                scanner.nextLine(); // consume the invalid input
                System.out.println(new Entrada().getMessage());
                System.out.println("Try again:");
            }
        }
    }

    public static char llegirChar(String missatge) {
        System.out.println(missatge);
        while (true) {
            try {
                String s = scanner.nextLine();
                if (s.length() == 1) {
                    return s.charAt(0);
                }
            } catch (Exception e) {
            }
            scanner.nextLine(); // consume the invalid input
            System.out.println(new Entrada().getMessage());
            System.out.println("Try again:");

        }
    }

    public static String llegirString(String missatge) {
        System.out.println(missatge);
        while (true) {
            try {
                String s = scanner.nextLine();
                return s;
            } catch (Exception e) {
                scanner.nextLine(); // consume the invalid input
                System.out.println(new Entrada().getMessage());
                System.out.println("Try again:");
            }
        }
    }

    public static boolean llegirSiNo(String missatge) {
        System.out.println(missatge);
        while (true) {
            try {
                String s = scanner.nextLine();
                if (s.length() == 1) {
                    char c = s.toLowerCase().charAt(0);
                    if (c == 's') {
                        return true;
                    }
                    if (c == 'n')
                        return false;
                }
            } catch (Exception e) {
            }
            scanner.nextLine(); // consume the invalid input
            System.out.println(new Entrada().getMessage());
            System.out.println("Try again:");
        }
    }

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Entrada {
       /*
        System.out.println("byte: " + llegirByte("Insert a byte (-128 to 127): "));
        System.out.println("int: " + llegirInt("Insert an int: "));
        System.out.println("float: " + llegirFloat("Insert a float: "));
        */
        System.out.println("double: " + llegirDouble("Insert a double: "));
        System.out.println("char: " + llegirChar("Insert a char: "));
        System.out.println("string: " + llegirChar("Insert a string: "));
        System.out.println("bool: " + llegirSiNo("Insert 's' for 'yes', 'n' for no: "));
    }

}

