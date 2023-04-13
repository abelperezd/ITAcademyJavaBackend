package n2;

public class SpainAddress implements IAddress {
    private String street;
    private String number;
    private String city;
    private String autonomousCommunity;
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
        return autonomousCommunity;
    }

    public String getZipCode() {
        return zipCode;
    }

    @Override
    public String getFullAddress() {

        return street + number + ", " + city + ", " + autonomousCommunity + ", " + zipCode;
    }

    public void insertAddress(String street, String number, String city, String autonomousCommunity, String zipCode) {
        this.street = street;
        this.number = number;
        this.city = city;
        this.autonomousCommunity = autonomousCommunity;
        this.zipCode = zipCode;
    }
}
