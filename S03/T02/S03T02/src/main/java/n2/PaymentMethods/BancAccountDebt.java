package n2.PaymentMethods;

import n2.Account;
import n2.Interfaces.IPayment;

import java.util.Date;

public class BancAccountDebt implements IPayment {
    private Date paymentDay;

    public BancAccountDebt(Date paymentDay) {
        this.paymentDay = paymentDay;
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
