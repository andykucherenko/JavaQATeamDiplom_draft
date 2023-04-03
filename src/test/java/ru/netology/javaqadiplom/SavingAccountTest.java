package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SavingAccountTest {

    @Test
    public void testConstructor() {
        SavingAccount account = new SavingAccount(1000, 500, 2000, 5);
        Assertions.assertEquals(1000, account.getBalance());
        Assertions.assertEquals(500, account.getMinBalance());
        Assertions.assertEquals(2000, account.getMaxBalance());
        Assertions.assertEquals(5, account.getRate());
    }

    @Test
    public void testConstructorWithInvalidBalance() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(2000, 500, 1500, 5);
        });
    }

    @Test
    public void testConstructorNegativeBalance() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(-1000, 500, 1500, 5);
        });
    }

    @Test
    public void testConstructorNegativeRate() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(1000, 500, 1500, -5);
        });
    }

    @Test
    public void testPayWithValidAmountBetweenMinAndMaxBalance() {
        SavingAccount account = new SavingAccount(100, 50, 200, 10);
        Assertions.assertFalse(account.pay(60));
        Assertions.assertEquals(40, account.getBalance());
    }

    @Test
    public void testPay() {
        SavingAccount account = new SavingAccount(1000, 500, 2000, 5);
        boolean result = account.pay(500);
        Assertions.assertTrue(result);
        Assertions.assertEquals(500, account.getBalance());
    }

    @Test
    public void testPayWithNegativeAmount() {
        SavingAccount account = new SavingAccount(1000, 500, 2000, 5);
        boolean result = account.pay(-500);
        Assertions.assertEquals(false, result);
        Assertions.assertEquals(1000, account.getBalance());
    }

    @Test
    public void testPayBelowMinimumBalance() {
        SavingAccount account = new SavingAccount(1000, 500, 2000, 5);
        boolean result = account.pay(800);
        Assertions.assertEquals(false, result);
        Assertions.assertEquals(200, account.getBalance());
    }

    @Test
    public void testPayOverMaximumBalance() {
        SavingAccount account = new SavingAccount(1000, 500, 2000, 5);
        boolean result = account.pay(3000);
        Assertions.assertEquals(false, result);
    }

    @Test
    public void testPayWithZeroAmount() {
        SavingAccount account = new SavingAccount(1000, 500, 2000, 5);
        boolean result = account.pay(0);
        Assertions.assertFalse(result);
        Assertions.assertEquals(1000, account.getBalance());
    }

    @Test
    public void testAdd() {
        SavingAccount account = new SavingAccount(1000, 500, 2000, 5);
        boolean result = account.add(500);
        Assertions.assertEquals(true, result);
        Assertions.assertEquals(1500, account.getBalance());
    }

    @Test
    public void testAddWithNegativeAmount() {
        SavingAccount account = new SavingAccount(1000, 500, 2000, 5);
        boolean result = account.add(-500);
        Assertions.assertEquals(false, result);
        Assertions.assertEquals(1000, account.getBalance());
    }

    @Test
    public void testAddAboveMaximumBalance() {
        SavingAccount account = new SavingAccount(1000, 500, 2000, 5);
        boolean result = account.add(1500);
        Assertions.assertEquals(false, result);
        Assertions.assertEquals(1000, account.getBalance());
    }

    @Test
    public void testYearChange() {
        SavingAccount account = new SavingAccount(1000, 500, 2000, 5);
        int result = account.yearChange();
        Assertions.assertEquals(50, result);
    }

    @Test
    public void testConstructorWithValidInitialBalance() {
        SavingAccount account = new SavingAccount(100, 50, 200, 10);
        assertNotNull(account);
        Assertions.assertEquals(100, account.getBalance());
    }

    @Test
    public void testConstructorWithInitialBalanceGreaterThanMaxBalance() {
        SavingAccount account = new SavingAccount(300, 50, 500, 15);
    }

    @Test
    void testInitialBalance() {
        SavingAccount account = new SavingAccount(1000, 500, 2000, 5);
        assertEquals(1000, account.getBalance());
    }

    @Test
    void testMinBalance() {
        SavingAccount account = new SavingAccount(1000, 500, 2000, 5);
        assertEquals(500, account.getMinBalance());
    }

    @Test
    void testMaxBalance() {
        SavingAccount account = new SavingAccount(1000, 500, 2000, 5);
        assertEquals(2000, account.getMaxBalance());
    }

    @Test
    void testRate() {
        SavingAccount account = new SavingAccount(1000, 500, 2000, 5);
        assertEquals(5, account.getRate());
    }

    @Test
    void testNegativeRate() {
        SavingAccount account = new SavingAccount(1000, 500, 2000, 5);
        assertThrows(IllegalArgumentException.class, () -> new SavingAccount(1000, 500, 2000, -10));
    }

    @Test
    void testPaySuccess() {
        SavingAccount account = new SavingAccount(1000, 500, 2000, 5);
        assertTrue(account.pay(100));
        assertEquals(900, account.getBalance());
    }

    @Test
    void testAddSuccess() {
        SavingAccount account = new SavingAccount(1000, 500, 2000, 5);
        assertTrue(account.add(500));
        assertEquals(1500, account.getBalance());
    }

    @Test
    void testAddFail() {
        SavingAccount account = new SavingAccount(1000, 500, 2000, 5);
        assertFalse(account.add(1500));
        assertEquals(1000, account.getBalance());
    }

    @Test
    void testYearChangeZeroRate() {
        SavingAccount account = new SavingAccount(1000, 500, 2000, 5);
        account.setRate(0);
        assertEquals(0, account.yearChange());
    }

    private Account account;

    @BeforeEach
    public void setUp() {
        account = new Account();
        account.balance = 100;
        account.rate = 5;
    }

    @Test
    public void testPayWithPositiveAmountGreaterThanBalance() {
        boolean result = account.pay(150);
        Assertions.assertFalse(result);
        Assertions.assertEquals(100, account.balance);
    }

    @Test
    public void testAddWithZeroAmount() {
        boolean result = account.add(0);
        Assertions.assertFalse(result);
        Assertions.assertEquals(100, account.balance);
    }

    @Test
    public void testAddWithPositiveAmountLessThanMaxBalance() {
        boolean result = account.add(100);
        Assertions.assertFalse(result);
        Assertions.assertEquals(100, account.balance);
    }

    @Test
    public void testAddWithPositiveAmountEqualToMaxBalance() {
        boolean result = account.add(100);
        Assertions.assertFalse(result);
        Assertions.assertEquals(100, account.balance);
    }

    @Test
    public void testAddWithPositiveAmountGreaterThanMaxBalance() {
        boolean result = account.add(1001);
        Assertions.assertFalse(result);
        Assertions.assertEquals(100, account.balance);
    }

    @Test
    public void testCountingYearChangeIfBalanceConstant() {
        int result = account.yearChange();
        account.setRate(5);
        assertEquals(0, result);



    }
}
