package service;

import domain.ClientCard;
import domain.Drug;
import domain.Transaction;
import repository.TransactionRepository;
import repository.TransactionRepositoryImpl;

import java.util.*;

public class TransactionService {

    private TransactionRepository transactionRepository;

    public TransactionService() {
        this.transactionRepository = new TransactionRepositoryImpl();
    }

    public void save(int idTransaction, int idDrug, int pillsNumber, int idClient, Date transactionDate) {
        Transaction transaction = new Transaction(idTransaction, idDrug, pillsNumber, idClient, transactionDate);
        transactionRepository.save(transaction);
    }

    public Transaction findById(int id) {
        return transactionRepository.findById(id);
    }

    public void updatePriceDrug(int id, int updatePillsNumber) {
        Transaction transaction = new Transaction();
        transaction.setIdTransaction(id);
        transaction.setPillsNumber(updatePillsNumber);
        transactionRepository.update(updatePillsNumber, transaction);
    }

    public void deleteByID(int id) {
        transactionRepository.deleteById(id);
    }

    public double printCost(int idPrintTransaction, DrugService drugService, ClientCardService cardService) {
        Transaction transaction = transactionRepository.findById(idPrintTransaction);
        Drug drug = drugService.findById(transaction.getIdDrug());
        double price = drug.getPrice() * transaction.getPillsNumber();

        ClientCard clientCard = cardService.findById(transaction.getIdClient());

        if (clientCard != null) {
            if (drug.isRecipe()) {
                // 15% reduction in price
                price = price * 0.85;
                System.out.println("Discount applied for 15%");
            } else {
                price = price * 0.9;
                System.out.println("Discount applied for 10%");
            }
        } else {
            System.out.println("No discount applied");
        }
        return price;
    }

    public List<Transaction> searchIntervalTransactions(Date startingDate, Date endingDate) {
        List<Transaction> transactionList = transactionRepository.findAll();
        List<Transaction> tempList = new ArrayList<>();
        for (Transaction checkTransactions : transactionList) {
            if (checkTransactions.getTransactionDate() != null &&
                    !checkTransactions.getTransactionDate().before(startingDate) &&
                    !checkTransactions.getTransactionDate().after(endingDate)) {
                tempList.add(checkTransactions);
            }
        }
        return tempList;
    }

    public void deleteIntervalTransactions(Date startingDate, Date endingDate) {
        List<Transaction> transactionList = transactionRepository.findAll();
        for (Transaction checkTransactions : new ArrayList<>(transactionList)) {
            if (checkTransactions.getTransactionDate() != null &&
                    !checkTransactions.getTransactionDate().before(startingDate) && !transactionList.isEmpty() &&
                    !checkTransactions.getTransactionDate().after(endingDate)) {
                transactionList.remove(checkTransactions);
            }
        }
    }

    //LocalDateTime si LocalDate
    //service nu se pune ca parametru. e necesar sa aducem repository

    //1.6.Afișarea medicamentelor ordonate descrescător după numărul de vânzări.
    //ce avem nevoie? id med si nr vanzari-lista cu ele, apelez collection.sort si returnez sort
    //
    public void printMostSoldDrugs(DrugService drugService) {
        Map<Integer, Integer> drugIdsMap = new HashMap<>();

        for (Transaction transaction : transactionRepository.findAll()) {
            Integer appearanceCounter = 0;

            if (drugIdsMap.containsKey(transaction.getIdDrug())) {
                appearanceCounter = drugIdsMap.get(transaction.getIdDrug());
            }

            drugIdsMap.put(transaction.getIdDrug(), appearanceCounter + 1);
        }

//        List<Map.Entry<Integer, Integer>> sortedList = drugIdsMap.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).toList();
        List<Map.Entry<Integer, Integer>> drugsIdsList = new ArrayList<>(drugIdsMap.entrySet()); //map entry - interface
        Collections.sort(drugsIdsList, Comparator.comparing(Map.Entry::getValue)); // cream un comparator care compara elementele bazate pe o cheie

        for (Map.Entry<Integer, Integer> drugInfo : drugsIdsList) {
            Drug tempDrug = drugService.findById(drugInfo.getKey());  //returneaza obiectul drug pe baza cheii din entry

            System.out.println("Drug name: " + tempDrug.getName() + " Sold: " + drugInfo.getValue());
        }
    }

    //1.7. Afișarea cardurilor client ordonate descrescător după valoarea reducerilor obținute.
    public List<Map.Entry<Integer, Double>> sortCardClient(DrugService drugService, ClientCardService clientCardService) {
        List<Transaction> transactionList = transactionRepository.findAll();
        Map<Integer, Double> sortMapCard = new HashMap<>();
        for (Transaction transaction : transactionList) {
            ClientCard clientCard = clientCardService.findById(transaction.getIdClient());
            Drug drug = drugService.findById(transaction.getIdDrug());
            double price = drug.getPrice() * transaction.getPillsNumber();
            double priceReduced;
            double discountValue;
            if (clientCard != null) {
                if (drug.isRecipe()) {
                    // 15% reduction in price
                    priceReduced = price * 0.85;
                    discountValue = price - priceReduced;  //valoarea reducerii
                } else {
                    priceReduced = price * 0.9;
                    discountValue = price - priceReduced;  //valoarea reducerii
                    System.out.println("Discount applied for 10%");
                }
                double currentValue=0;
                if (sortMapCard.get(clientCard.getId()) != null) {
                   currentValue = sortMapCard.get(clientCard.getId()); //returnez valoarea dupa cheia id.
                }
                    sortMapCard.put(clientCard.getId(), discountValue + currentValue);
            }
        }
        List<Map.Entry<Integer, Double>> cardsList = new ArrayList<>(sortMapCard.entrySet());
        Collections.sort(cardsList, Comparator.comparing(Map.Entry::getValue));
        return cardsList;
    }
}