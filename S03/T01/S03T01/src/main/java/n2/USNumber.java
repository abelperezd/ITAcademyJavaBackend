package n2;

public class USNumber implements INumber {
    private final String countryCode = "+1";
    private String region;
    private String localNumber;

    public String getRegion() {
        return region;
    }

    public String getLocalNumber() {
        return localNumber;
    }

    @Override
    public String getFullNumber() {
        return countryCode + region + localNumber;
    }

    public void insertNumber(String region, String localNumber) {
        this.region = region;
        this.localNumber = localNumber;
    }
}
