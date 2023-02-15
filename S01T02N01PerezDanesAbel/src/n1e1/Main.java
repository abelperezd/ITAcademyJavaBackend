package n1e1;

public class Main {
    public static void main(String[] args) throws Exception {

        Venda venda = new Venda();
        venda.AddProduct(new Producte("butifarra", 1.5f));
        venda.AddProduct(new Producte("ous", 2f));
        venda.AddProduct(new Producte("patates", 1.35f));

        venda.CalcularTotal();
        System.out.println("price: " + venda.getTotalPrice() + "€");

        //To generate the exception
        new Venda().CalcularTotal();
    }
}
