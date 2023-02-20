package n1e2;

public class CalculoDni {
    private static final String DNI_LETTERS = "TRWAGMYFPDXBNJZSQVHLCKE";
    public static char computeDniLetter(String dniNumberString){
        int dniNumber = Integer.parseInt(dniNumberString);
        int remainder = dniNumber % 23;
        return DNI_LETTERS.charAt(remainder);
    }
}
