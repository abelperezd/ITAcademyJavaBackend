package n2;

import n2.Interfaces.IPayment;

public class PaymentProxy implements IPayment {

    private IPayment payment;

    public PaymentProxy(IPayment payment) {
        this.payment = payment;
    }

    @Override
    public void DoPayment(Account receiver, Account sender, float amount) {
        payment.DoPayment(receiver, sender, amount);
    }

    @Override
    public void ShowMoneyInAccount(Account account) {
        System.out.println(account.getName() + ", money in account: " + account.getMoney());
    }
}
