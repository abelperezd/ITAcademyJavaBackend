package n2;

import java.util.HashMap;
import java.util.LinkedList;

public class Book implements IAddressFactory {

    private HashMap<Integer, IAddress> addresses = new HashMap<>();
    private HashMap<Integer, INumber> numbers = new HashMap<>();
    private IAddressFactory addressFactory;


    ///region Getters And Setters

    public void setAddressFactory(IAddressFactory addressFactory) {
        this.addressFactory = addressFactory;
    }

    public void addAddress(int index, IAddress address) {
        addresses.put(index, address);
    }

    public void addNumber(int index, INumber number) {
        numbers.put(index, number);
    }

    public IAddress getAddress(int index) {
        return addresses.get(index);
    }

    public INumber getNumber(int index) {
        return numbers.get(index);
    }

    ///endregion

    @Override
    public INumber createNumber() {
        return addressFactory.createNumber();
    }

    @Override
    public IAddress createAddress() {
        return addressFactory.createAddress();
    }
}
