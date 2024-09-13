package services;

import java.util.LinkedList;
import java.util.List;

public class TransactionHistory {
    private final List<String> history;

    public TransactionHistory() {
        this.history = new LinkedList<>();
    }

    public void addTransaction(String transaction) {
        history.add(0, transaction);
    }

    public void displayAllTransactions() {
        history.forEach(System.out::println);
    }

    public void displayAllTransactionsParallel() {
        history.parallelStream().forEach(System.out::println);
    }
}

