package n1;

public interface IObservable {
    void notifyObservers(Stock stock);
    void addObserver(IObserver observer);
    void removeObserver(IObserver observer);
}
