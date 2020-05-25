package com.nova.app.account;

import com.nova.app.constant.Constants;
import com.nova.app.model.Transaction;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * It is an abstract class that defines a bank account.
 */
@Getter
@Setter
public abstract class BankAccount {
    protected String accountNumber;
    protected Double minimumBalance;
    protected Double currentBalance;
    protected Double interestRate;
    protected List<Transaction> transactions;

    /**
     * @return
     */
    public abstract String getType();

    /**
     * It withdraws the amount from the bank account. If the value of
     * the currentBalance attribute becomes less than the value of
     * the minimumBalance attribute, then the transaction is unsuccessful and an exception is raised.
     *
     * @param amount
     *
     * @return
     */
    public Transaction withdraw(Double amount) throws Exception {
        double afterTransaction = this.currentBalance - amount;
        if (afterTransaction < this.minimumBalance) {
            throw new Exception("The given amount cant be withdrawn due to insufficient balance");
        }
        this.currentBalance = afterTransaction;
        return prepareTransaction(Constants.WITHDRAW, amount);
    }

    /**
     * It deposits the amount into the bank account. If the amount is
     * negative, then the transaction is unsuccessful and an exception is raised. In case of a successful
     * transaction, the currentBalance attribute is updated
     *
     * @param amount
     *
     * @return
     */
    public Transaction deposit(Double amount) throws Exception {
        if (amount <= 0) {
            throw new Exception("The given amount is not valid.Please enter valid number");
        }
        this.currentBalance = this.currentBalance + amount;
        return prepareTransaction(Constants.DEPOSIT, amount);
    }

    /**
     * the transactionId attribute is set to as one greater than the ID of the last
     * transaction. The ID of the first transaction is 1 and of the second transaction is 2 and so on.
     *
     * @param type
     * @param amount
     *
     * @return
     */
    private Transaction prepareTransaction(String type, Double amount) {
        Transaction transaction = new Transaction();
        transaction.setType(type);
        int size = this.transactions.size();
        int id;
        if (size == 0) {
            id = 1;
        } else {
            String transactionId = this.transactions.get(size - 1).getTransactionId();
            id = Integer.parseInt(transactionId) + 1;
        }
        transaction.setTransactionId(id + "");
        transaction.setAmount(amount);
        return transaction;
    }

    /**
     * It returns the list of transactions.
     *
     * @return
     */
    public List<Transaction> getTransactionHistory() {
        return this.transactions;
    }

    /**
     * It returns the last 10 transactions with the latest transaction at the end of
     * the list.
     *
     * @return
     */
    public List<Transaction> getMiniStatement() {
        return this.transactions.subList(Math.max(this.transactions.size() - 10, 0), this.transactions.size());
    }

}
