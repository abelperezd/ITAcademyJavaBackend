package n3.currency;

import n3.articles.IArticle;

import java.util.LinkedList;
import java.util.List;

public class PricePrinter implements IArticle {
    private LinkedList<IArticle> articles = new LinkedList<>();

    @Override
    public void printPrice(Currency c) {
        articles.forEach(a -> a.printPrice(c));
    }

    public void insertArticle(IArticle... articles) {
        this.articles.addAll(List.of(articles));
    }
}
