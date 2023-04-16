package n1;

import java.util.ArrayList;
import java.util.List;

public class AgencyObserver implements IObserver {

    //region Attributes

    private String _name;
    private IObservable _observable;

    //endregion Attributes

    //region Constructor, getters and setters

    public AgencyObserver(String name) {
        _name = name;
    }

    public String getName() {
        return _name;
    }

    //endregion Constructor, getters and setters

    //region Observer

    @Override
    public void update(Stock stock) {
        System.out.println(_name + ": stock updated -> Name:" + stock.getName() + " - Price: " + stock.getPrice());
    }

    @Override
    public void setObservable(IObservable observable) {
        _observable = observable;
    }

    @Override
    public void removeObservable() {
        _observable.removeObserver(this);
        _observable = null;
    }

    //endregion Observer
}
