package com.nova.app.account;

import com.nova.app.constant.Constants;
import lombok.Getter;

import java.util.ArrayList;

/**
 * This class is a specialization of the BankAccount attribute with the following features:
 * 1. getType(): Returns a string that is denoted as Current
 * 2. minimumBalance is 20000.0
 * 3. interestRate is 0%
 */
@Getter
public class CurrentAccount extends BankAccount {

    public CurrentAccount() {
        this.transactions = new ArrayList<>();
        this.minimumBalance = 20000.0;
        this.interestRate = 0.0;
        this.currentBalance = 0.0;
    }

    @Override
    public String getType() {
        return Constants.CURRENT;
    }
}
