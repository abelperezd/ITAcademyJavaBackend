package n2;

import n2.Interfaces.IPayment;
import n2.PaymentMethods.Paypal;

public class Main {

    public static void main(String[] args) {
        Account accountA = new Account("James", 250);

        Account accountB = new Account("Marta", 370);

        IPayment paymentProxy = new PaymentProxy(new Paypal("Jamesito", "1234"));

        paymentProxy.DoPayment(accountA, accountB, 50);

        paymentProxy.ShowMoneyInAccount(accountA);
        paymentProxy.ShowMoneyInAccount(accountB);

    }
}
