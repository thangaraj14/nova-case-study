package com.nova.app.model;

import lombok.Getter;
import lombok.Setter;

/**
 * It represents all the transactions that are made against a bank account.
 */
@Getter
@Setter
public class Transaction {

    private String transactionId;
    private Double amount;
    private String type;
}
