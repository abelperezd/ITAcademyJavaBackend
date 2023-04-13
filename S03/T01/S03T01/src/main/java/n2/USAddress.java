package n2;

public class USAddress implements IAddress {
    private String street;
    private String number;
    private String city;
    private String state;
    private String zipCode;

    public String getStreet() {
        return street;
    }

    public String getNumber() {
        return number;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZipCode() {
        return zipCode;
    }

    @Override
    public String getFullAddress() {

        return street + number + ", " + city + ", " + state + ", " + zipCode;
    }

    public void insertAddress(String street, String number, String city, String state, String zipCode) {
        this.street = street;
        this.number = number;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }
}
