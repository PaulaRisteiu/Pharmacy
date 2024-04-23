package domain;

import java.util.Date;

public class Transaction {

    private int idTransaction;
    private int idDrug;
    private int pillsNumber;
    private int idClient; //null or not
    private Date transactionDate; //dd.mm.yyyy HH.mm

    public Transaction() {
    }

    public Transaction(int idTransaction, int idDrug, int pillsNumber, int idClient, Date transactionDate) {
        this.idTransaction = idTransaction;
        this.idDrug = idDrug;
        this.pillsNumber = pillsNumber;
        this.idClient = idClient;
        this.transactionDate = transactionDate;
    }

    public int getIdTransaction() {
        return idTransaction;
    }

    public void setIdTransaction(int idTransaction) {
        this.idTransaction = idTransaction;
    }

    public int getIdDrug() {
        return idDrug;
    }

    public void setIdDrug(int idDrug) {
        this.idDrug = idDrug;
    }

    public int getPillsNumber() {
        return pillsNumber;
    }

    public void setPillsNumber(int pillsNumber) {
        this.pillsNumber = pillsNumber;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "idTransaction=" + idTransaction +
                ", idDrug=" + idDrug +
                ", pillsNumber=" + pillsNumber +
                ", idClient=" + idClient +
                ", transactionDate=" + transactionDate +
                '}';
    }
}
