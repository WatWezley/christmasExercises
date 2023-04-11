package xmasExercise;

import accountClass.Account;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {
   private Account account;

    @BeforeEach
    public void setUp() {
        account = new Account(1, "Josh", "1234");
    }


    @Test
    public void depositMoneyTest(){
        account.deposit(BigDecimal.valueOf(2_000));
        assertEquals(BigDecimal.valueOf(2_000), account.getBalance("1234"));
    }

    @Test
    public void getBalanceWithCorrectPinTest(){
        account.deposit(BigDecimal.valueOf(2_000));
        assertEquals(BigDecimal.valueOf(2_000), account.getBalance("1234"));

    }

    @Test
    public void getBalanceWithWrongPinThrowExceptionTest(){
        account.deposit(BigDecimal.valueOf(2_000));
        assertThrows(IllegalArgumentException.class, ()-> account.getBalance("2231"));
    }

    @Test
    public void withdrawFromAccountTest(){
        account.deposit(BigDecimal.valueOf(2_000));
        account.withdraw(BigDecimal.valueOf(1000), "1234");
        assertEquals(BigDecimal.valueOf(1_000), account.getBalance("1234"));
    }
    @Test
    public void withdrawFromAccountwithWrongPinTest(){
        account.deposit(BigDecimal.valueOf(2_000));
        assertThrows(IllegalArgumentException.class, ()-> account.withdraw(BigDecimal.valueOf(1000), "5464"));

    }
    @Test
    public void withdrawFromAccountwithRightPinTest() {
        account.deposit(BigDecimal.valueOf(2_000));
        account.withdraw(BigDecimal.valueOf(1000), "1234");
        assertEquals(BigDecimal.valueOf(1_000), account.getBalance("1234"));

    }
    @Test
    public void withdrawFromAccountwithamountGreaterThanBalanceTest() {
        account.deposit(BigDecimal.valueOf(2_000));
        account.withdraw(BigDecimal.valueOf(4000), "1234");
        assertEquals(BigDecimal.valueOf(-2_000), account.getBalance("1234"));

    }

}