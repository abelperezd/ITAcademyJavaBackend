package n1;

import java.util.LinkedList;

public class StockMarket implements IObservable {

    //region Attributes
    private LinkedList<Stock> _stocks = new LinkedList<>();
    private LinkedList<IObserver> _observers = new LinkedList<>();

    //endregion

    public void addStock(Stock... stocks) {
        for (Stock stock : stocks) {
            _stocks.add(stock);
        }
    }

    public void removeStock(Stock stock) {
        _stocks.removeIf(s -> s.equals(stock));
    }

    public Stock getStock(String name) {
        for (Stock s : _stocks) {
            if (s.getName().equalsIgnoreCase(name)) {
                return s;
            }
        }
        return null;
    }

    public void updateStockPrice(String name, float price) {
        _stocks.forEach(s -> {
            if (s.getName().equalsIgnoreCase(name)) {
                s.setPrice(price);
                notifyObservers(s);
                return;
            }
        });
    }

    //region Observable

    @Override
    public void notifyObservers(Stock stock) {
        _observers.forEach(o -> o.update(stock));
    }

    @Override
    public void addObserver(IObserver observer) {
        _observers.add(observer);
    }

    @Override
    public void removeObserver(IObserver observer) {
        _observers.removeIf(o -> o.equals(observer));
    }

    //endregion Observable
}
