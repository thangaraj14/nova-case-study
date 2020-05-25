package com.nova.app.account;

import com.nova.app.model.Transaction;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class CurrentAccountTest {

    @InjectMocks
    CurrentAccount currentAccount;

    @Test(expected = Exception.class)
    public void testSavingAccountWithInsufficientBalance() throws Exception {
        currentAccount.withdraw(2000.0);
    }

    @Test
    public void testSavingAccountWithSufficientBalance() throws Exception {
        currentAccount.setCurrentBalance(40000.0);
        Transaction transaction = currentAccount.withdraw(10000.0);
        Assert.assertEquals(10000.0, transaction.getAmount(), 0.0);
    }

    @Test
    public void testDepositWithValidValue() throws Exception {
        Transaction transaction = currentAccount.deposit(2000.0);
        Assert.assertEquals(2000.0, transaction.getAmount(), 0.0);
    }

    @Test(expected = Exception.class)
    public void testDepositWithInvalidValue() throws Exception {
        currentAccount.deposit(0.0);
    }
}
