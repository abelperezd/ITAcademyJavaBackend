package n2e1;

public class Main {
    /*
     * Explicació: "final" vol dir que la variable s'ha d'inicialitzar quan es declara, i no es pot canviar
     * el seu valor més endavant. "static" vol dir que pertany a les classes, no a les instàncies.
     * Responent a la pregunta: Si, donat que model es estàtic, però no es final, es pot canviar el seu
     * valor sempre que es vulgui, com per exemple al constructor.
     */
    public static void main(String[] args) {

        Smarthpone t = new Smarthpone("Samsung", "Galaxy S7");

        t.call("666 555 444");
        t.fotografiar();
        t.alarma();
    }
}
