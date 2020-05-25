package com.nova.app.account;

import com.nova.app.constant.Constants;
import lombok.Getter;

import java.util.ArrayList;

/**
 * This class is a specialization of the BankAccount attribute with the following features:
 * 1. getType(): Returns a string that is denoted as Saving
 * 2. minimumBalance is 10000.0
 * 3. interestRate is 4.5%
 */
@Getter
public class SavingAccount extends BankAccount {

    public SavingAccount() {
        this.transactions = new ArrayList<>();
        this.minimumBalance = 10000.0;
        this.interestRate = 4.5;
        this.currentBalance = 0.0;
    }

    @Override
    public String getType() {
        return Constants.SAVING;
    }
}
