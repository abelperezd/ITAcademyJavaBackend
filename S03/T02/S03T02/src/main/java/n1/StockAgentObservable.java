package n1;

import java.util.LinkedList;

public class StockAgentObservable implements IObserver, IObservable {

    private LinkedList<IObserver> _observers = new LinkedList<>();
    private IObservable _observable;

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

    //region Observer

    @Override
    public void update(Stock stock) {
        notifyObservers(stock);
    }

    @Override
    public void setObservable(IObservable observable) {
        _observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void removeObservable() {
        _observable.removeObserver(this);
        _observable = null;
    }

    //endregion Observer
}
