package n2;

public class USAddressFactory implements IAddressFactory {
    @Override
    public INumber createNumber() {
        return new USNumber();
    }

    @Override
    public IAddress createAddress() {
        return new USAddress();
    }
}
