package com.nova.app.branch;

import com.nova.app.account.BankAccount;
import com.nova.app.account.SavingAccount;
import com.nova.app.model.Customer;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author i312458
 */
@RunWith(SpringRunner.class)
public class BranchTest {

    @InjectMocks
    Branch branch;

    @Spy
    List<Customer> customers;

    @Spy
    List<BankAccount> bankAccounts;

    @Test
    public void testCreateBankAccount() throws Exception {
        Customer customer = branch.createBankAccount("TREWQ1234P", "Saving", 2000.0);
        Assert.assertEquals(customer.getBankAccounts().size(), 1);
        Assert.assertEquals(customer.getPanNumber(), "TREWQ1234P");
        Assert.assertEquals(customer.getBankAccounts().get(0).getType(), "Saving");
    }

    @Test(expected = Exception.class)
    public void testCreateBankAccountWithInvalidType() throws Exception {
        branch.createBankAccount("TREWQ1234", "Credit", 2000.0);
    }

    @Test(expected = Exception.class)
    public void testGetCustomerByInvalidPan() throws Exception {
        branch.getCustomerByPan("");
    }

    @Test
    public void testGetCustomerByValidPan() throws Exception {

        Customer customer = new Customer("MNBVC3421Y");
        customers = new ArrayList<>(Arrays.asList(customer));
        branch.setCustomers(customers);
        Customer result = branch.getCustomerByPan("MNBVC3421Y");
        Assert.assertEquals("MNBVC3421Y", result.getPanNumber());
    }

    @Test
    public void testGetAccountByAccountNumber() throws Exception {

        SavingAccount savingAccount = new SavingAccount();
        savingAccount.setAccountNumber("12");
        bankAccounts = new ArrayList<>(Arrays.asList(savingAccount));
        branch.setBankAccounts(bankAccounts);
        BankAccount result = branch.getAccountByAccountNumber("12");
        Assert.assertEquals("12", result.getAccountNumber());
    }

    @Test(expected = Exception.class)
    public void testGetAccountByInvalidAccountNumber() throws Exception {

        SavingAccount savingAccount = new SavingAccount();
        savingAccount.setAccountNumber("12");
        bankAccounts = new ArrayList<>(Arrays.asList(savingAccount));
        branch.setBankAccounts(bankAccounts);
        branch.getAccountByAccountNumber("17");
    }

    @Test(expected = Exception.class)
    public void testGetAccountByNullAccountNumber() throws Exception {

        SavingAccount savingAccount = new SavingAccount();
        savingAccount.setAccountNumber("12");
        bankAccounts = new ArrayList<>(Arrays.asList(savingAccount));
        branch.setBankAccounts(bankAccounts);
        branch.getAccountByAccountNumber(null);
    }
}
