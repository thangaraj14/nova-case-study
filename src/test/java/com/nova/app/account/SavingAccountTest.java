package com.nova.app.account;

import com.nova.app.model.Transaction;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 */
@RunWith(SpringRunner.class)
public class SavingAccountTest {

    @InjectMocks
    SavingAccount savingAccount;

    @Test(expected = Exception.class)
    public void testSavingAccountWithInsufficientBalance() throws Exception {
        Transaction withdraw = savingAccount.withdraw(2000.0);
    }

    @Test
    public void testSavingAccountWithSufficientBalance() throws Exception {
        savingAccount.setCurrentBalance(40000.0);
        Transaction withdraw = savingAccount.withdraw(10000.0);
        Assert.assertEquals(10000.0, withdraw.getAmount(), 0.0);
    }

    @Test
    public void testDepositWithValidValue() throws Exception {
        Transaction transaction = savingAccount.deposit(2000.0);
        Assert.assertEquals(2000.0, transaction.getAmount(), 0.0);
    }

    @Test(expected = Exception.class)
    public void testDepositWithInvalidValue() throws Exception {
        savingAccount.deposit(0.0);
    }
}
