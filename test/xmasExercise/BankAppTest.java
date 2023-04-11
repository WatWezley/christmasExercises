package xmasExercise;

import accountClass.Bank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankAppTest {
    Bank wemaBank;

    @BeforeEach
    public void setUp() {
        wemaBank = new Bank();
        wemaBank.createAccountFor("Joshua", "Oluwakuse", "1234");
    }


    @Test
    public void accountCanBeCreatedInBankTest() {

        assertEquals(1, wemaBank.getNumberOfCustomers());
    }

    @Test
    public void accountCanBeFoundAfterCreationTest() {
        String expected = """
                Account name: Oluwakuse Joshua
                Account Number: 1
                Account Balance: 0""";
        assertEquals(expected, wemaBank.findAccount(1).toString());
        }

    @Test
    public void balanceCanBeCheckedTest() {
        assertEquals(BigDecimal.ZERO, wemaBank.checkBalanceFor(1, "1234"));
    }

    @Test
    public void depositIntoAccount() {
        wemaBank.depositInto(BigDecimal.valueOf(1200), 1);
        assertEquals(BigDecimal.valueOf(1200), wemaBank.checkBalanceFor(1, "1234"));
    }

    @Test
    public void withdrawFromAccountTest() {
        wemaBank.depositInto(BigDecimal.valueOf(1200), 1);
        wemaBank.withdrawFrom(1, BigDecimal.valueOf(200), "1234");
        assertEquals(BigDecimal.valueOf(1000), wemaBank.checkBalanceFor(1, "1234"));
    }

    @Test
    public void transferMoneyTest() {
        wemaBank.createAccountFor("All", "Well", "1111");
        wemaBank.depositInto(BigDecimal.valueOf(5000), 2);
        wemaBank.transfer(BigDecimal.valueOf(400), 2, 1, "1111");
        assertEquals(BigDecimal.valueOf(400), wemaBank.checkBalanceFor(1, "1234"));
        assertEquals(BigDecimal.valueOf(4600), wemaBank.checkBalanceFor(2, "1111"));

    }


}
