package n2.PaymentMethods;

import n2.Account;
import n2.Interfaces.IPayment;

public class Paypal implements IPayment {

    private String userName;
    private String password;

    public Paypal(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    @Override
    public void DoPayment(Account receiver, Account sender, float amount) {
        sender.removeMoney(amount);
        receiver.addMoney(amount);
    }

    @Override
    public void ShowMoneyInAccount(Account account) {
        System.out.println("Money in account: " + account.getMoney());
    }
}
