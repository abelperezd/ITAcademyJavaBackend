package n1;

public class Stock {
    private String _name;
    private float _price;

    //region Constructor, getters and setters

    public Stock(String name, float price) {
        _name = name;
        _price = price;
    }
    public String getName() {
        return _name;
    }

    public float getPrice() {
        return _price;
    }

    public void setPrice(float price) {
        _price = price;
    }

    //endregion
}
