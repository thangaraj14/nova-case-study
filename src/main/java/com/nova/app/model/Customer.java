package com.nova.app.model;

import com.nova.app.account.BankAccount;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * It represents the owner of one or more bank accounts.
 */
@Getter
@Setter
public class Customer {

    private List<BankAccount> bankAccounts;
    private String panNumber;

    public Customer(String panNumber) {
        this.panNumber = panNumber;
        this.bankAccounts = new ArrayList<>();
    }

}
