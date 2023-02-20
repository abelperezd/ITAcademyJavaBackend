package n1e1;

public class Main {
    public static void main(String[] args) throws Exception {

        Venda venda = new Venda();
        venda.addProduct(new Producte("butifarra", 1.5f));
        venda.addProduct(new Producte("ous", 2f));
        venda.addProduct(new Producte("patates", 1.35f));

        venda.calcularTotal();
        System.out.println("price: " + venda.getTotalPrice() + "€");

        //To generate the exception
        new Venda().calcularTotal();
    }
}
