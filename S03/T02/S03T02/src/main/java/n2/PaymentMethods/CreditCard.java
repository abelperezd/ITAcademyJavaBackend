package n2.PaymentMethods;

import n2.Account;
import n2.Interfaces.IPayment;

public class CreditCard implements IPayment {
    private String cardId;
    public CreditCard(String cardId) {
        this.cardId = cardId;
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
