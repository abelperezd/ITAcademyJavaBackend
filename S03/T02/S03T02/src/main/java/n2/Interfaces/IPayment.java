package n2.Interfaces;

import n2.Account;

public interface IPayment {
    void DoPayment(Account receiver, Account sender, float amount );

    void ShowMoneyInAccount(Account account);

}
