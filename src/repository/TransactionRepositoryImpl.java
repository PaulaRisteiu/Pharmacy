package repository;

import domain.ClientCard;
import domain.Drug;
import domain.Transaction;
import service.TransactionService;

import java.util.*;

public class TransactionRepositoryImpl implements TransactionRepository{
    private List<Transaction> transactionList;

    public TransactionRepositoryImpl() {
        this.transactionList = new ArrayList<>();
    }

    public boolean findTransaction (Transaction findTransaction) {
        for (Transaction transaction : transactionList) {
            if (transaction.equals(findTransaction)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Transaction> findAll() {
        return transactionList;
    }

    @Override
    public Transaction findById(int id) {
        for (Transaction transaction: transactionList) {
            if (transaction.getIdTransaction() == id) {
                return transaction;
            }
        }
        return null;
    }

    @Override
    public void save(Transaction transaction) {
        if (findById(transaction.getIdTransaction()) != null) {
            throw new RuntimeException("Id already exist");
        }
        transactionList.add(transaction);
    }

    @Override
    public void update(int id, Transaction transaction) {
        Transaction updateTransaction = findById(id);
        if (updateTransaction == null) {
            throw new RuntimeException("The drug doesn't exist");
        }
        updateTransaction.setPillsNumber(transaction.getPillsNumber());
    }

    @Override
    public void deleteById(int id) {
        Transaction deleteTransaction = findById(id);
        if (deleteTransaction == null) {
            throw new RuntimeException("The drug with this id doesn't exist");
        } else {
            transactionList.remove(deleteTransaction);
        }
    }
}
