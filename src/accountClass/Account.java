package accountClass;

import java.math.BigDecimal;

public class Account {

    private BigDecimal balance = BigDecimal.ZERO;
    private String pin;
    private String accountName;
    private int accountNumber;

    public Account(int accountNumber, String accountName, String accountPin) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        pin = accountPin;
    }

    public void deposit(BigDecimal amount) {
        balance = balance.add(amount);
    }

    public BigDecimal getBalance(String pin) {
        if(!pin.equals(this.pin))throw new IllegalArgumentException("Invalid Pin");
        return balance;
    }

    public BigDecimal withdraw(BigDecimal amount, String pin) {
        if(!pin.equals(this.pin))throw new IllegalArgumentException("Invalid Pin");
            balance = balance.subtract(amount);
            return balance;

}

    public String toString(){
        return String.format("""
                Account name: %s
                Account Number: %s
                Account Balance: %s""", accountName, accountNumber, balance.toPlainString());
    }

}
