package n2;

public class SpainAddressFactory implements IAddressFactory {
    @Override
    public INumber createNumber() {
        return new SpainNumber();
    }

    @Override
    public IAddress createAddress() {
        return new SpainAddress();
    }
}
