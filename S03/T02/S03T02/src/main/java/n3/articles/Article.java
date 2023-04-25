package n3.articles;

import n3.currency.Currency;
import n3.currency.CurrencyConverter;

public abstract class Article implements IArticle {
    protected String name;

    public Article(String name, float price, Currency currency) {
        this.name = name;
        this.price = price;
        this.currency = currency;
    }

    protected float price = 0;
    protected Currency currency = Currency.Euro;

    @Override
    public void printPrice(Currency c) {
        System.out.println(name + ": " + CurrencyConverter.getCurrencyConversion(price, currency, c)
                + CurrencyConverter.getSymbol(c));
    }
}
