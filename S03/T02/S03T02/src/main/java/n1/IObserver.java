package n1;

public interface IObserver {
    void update(Stock stock);
    void setObservable(IObservable observable);
    void removeObservable();
}
