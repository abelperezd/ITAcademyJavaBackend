package n1e1;

import java.util.ArrayList;
import java.util.Arrays;

public class Months {

    private ArrayList<String> monthsList;

    //Load the months when creating an instance
    public Months() {
        monthsList = new ArrayList<>(Arrays.asList("Gener", "Febrer", "Març",
                "Abril", "Maig", "Juny", "Juliol", "Agost", "Septembre", "Octubre", "Novembre", "Decembre"));
    }

    public ArrayList<String> getMonthsList() {
        return monthsList;
    }

}
