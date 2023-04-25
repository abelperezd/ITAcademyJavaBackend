package n2;

import n2.Interfaces.IPayment;

public class AccountImplementation implements IPayment {
    @Override
    public void DoPayment(Account receiver, Account sender, float amount) {
        sender.addMoney(amount);
        receiver.removeMoney(amount);
    }

    @Override
    public void ShowMoneyInAccount(Account account) {
        System.out.println("Money in account: " + account.getMoney());
    }
}
