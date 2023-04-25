package n3;

import n3.articles.Food;
import n3.articles.IArticle;
import n3.articles.Vehicle;
import n3.currency.Currency;
import n3.currency.PricePrinter;

public class Main {

    public static void main(String[] args) {
        PricePrinter pricePrinter = new PricePrinter();
        pricePrinter.insertArticle(
                new Food("orange", 0.5f, Currency.Euro),
                new Food("chicken", 2f, Currency.Dollar),
                new Vehicle("car", 8000f, Currency.Pound),
                new Vehicle("plane", 258000f, Currency.Pound)
        );
        pricePrinter.printPrice(Currency.Euro);
    }
}
