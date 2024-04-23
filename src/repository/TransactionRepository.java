package repository;

import domain.Drug;
import domain.Transaction;

import java.util.List;

public interface TransactionRepository {

    List<Transaction> findAll(); //read all
    Transaction findById(int id); //read by id
    void save(Transaction transaction); //
    void update(int id, Transaction transaction);
    void deleteById(int id);
}
