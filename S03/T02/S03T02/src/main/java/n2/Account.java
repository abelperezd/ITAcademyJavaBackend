package n2;

public class Account {

    private String name;
    private float money;

    public Account(String name, float money) {
        this.name = name;
        this.money = money;
    }

    public float getMoney() {
        return money;
    }

    public String getName() {
        return name;
    }

    public void removeMoney(float amount) {
        money -= amount;
    }

    public void addMoney(float amount) {
        money += amount;
    }

}
