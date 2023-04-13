package n2;

public class SpainNumber implements INumber {
    private final String countryCode = "+34";
    private String area;
    private String localNumber;

    public String getRegion() {
        return area;
    }

    public String getLocalNumber() {
        return localNumber;
    }

    @Override
    public String getFullNumber() {
        return countryCode + area + localNumber;
    }

    public void insertNumber(String region, String localNumber) {
        this.area = region;
        this.localNumber = localNumber;
    }
}
