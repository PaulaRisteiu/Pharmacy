package UI;

import domain.ClientCard;
import domain.Drug;
import domain.Transaction;
import service.ClientCardService;
import service.DrugService;
import service.TransactionService;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Consola {
    private Scanner scanner = new Scanner(System.in);
    private DrugService drugService;
    private ClientCardService clientCardService;
    private TransactionService transactionService;

    public void createService() {
        this.drugService = new DrugService();
        this.clientCardService = new ClientCardService();
        this.transactionService = new TransactionService();
    }

    public void menu() {
        System.out.println("0.Exit");
        System.out.println("1.Create Drug");
        System.out.println("2.Create ClientCard");
        System.out.println("3.Create Transaction");
        System.out.println("4.Display Drug");
        System.out.println("5.Display Client Card");
        System.out.println("6.Display Transaction");
        System.out.println("7.Update Drug");
        System.out.println("8.Update Client Card");
        System.out.println("9.Update Transaction");
        System.out.println("10.Delete Drug");
        System.out.println("11.Delete Client Card");
        System.out.println("12.Delete Transaction");
        System.out.println("13.Show prices with discounts for transaction");
        System.out.println("14.Search Drugs & Client");
        System.out.println("15.All Transactions from a given date interval:");
        System.out.println("16.Delete Transaction from a given date interval: ");
        System.out.println("17.Increase in target price: ");
        System.out.println("18.Sort by number of transaction: ");
        System.out.println("19.Sort by discounts: ");
    }

    public int readOption() {
        try {
            Scanner scanner = new Scanner(System.in);
            int option = scanner.nextInt();
            return option;
        } catch (Exception error) {
            return readOption();
        }
    }

    public void runMenu() {
        boolean flag = true;
        createService();
        while (flag) {
            menu();
            int option = readOption();
            switch (option) {
                case 0:
                    flag = false;
                    break;
                case 1:
                    System.out.println("Enter numberOfDrugs ");
                    int n = scanner.nextInt();
                    for (int i = 0; i < n; i++) {
                        System.out.println("Enter id: ");
                        int id = scanner.nextInt();
                        System.out.println("Enter name: ");
                        String name = scanner.next();
                        System.out.println("Enter producer: ");
                        String producer = scanner.next();
                        System.out.println("Enter price: ");
                        double price = scanner.nextDouble();
                        System.out.println("Enter recipe: ");
                        boolean recipe = scanner.nextBoolean();
                        try {
                            drugService.save(id, name, producer, price, recipe);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;
                case 2:
                    System.out.println("Enter numbersOfClient");
                    int a = scanner.nextInt();
                    for (int i = 0; i < a; i++) {
                        System.out.println("Enter id: ");
                        int id = scanner.nextInt();
                        System.out.println("Enter last name: ");
                        String lastName = scanner.next();
                        System.out.println("Enter firstName: ");
                        String firstName = scanner.next();
                        System.out.println("Enter CNP: ");
                        String CNP = scanner.next();
                        System.out.println("Enter birthday: ");
                        String birthDate = scanner.next();
                        System.out.println("Enter inregistration Date: ");
                        String inregistrationDate = scanner.next();

                        try {
                            DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
                            Date dateBirth = dateFormat.parse(birthDate);
                            Date dateRegistration = dateFormat.parse(inregistrationDate);
                            clientCardService.save(id, lastName, firstName, CNP, dateBirth, dateRegistration);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;
                case 3:
                    System.out.println("Enter numbersOfTransaction");
                    int b = scanner.nextInt();
                    for (int i = 0; i < b; i++) {
                        System.out.println("Enter id Transaction: ");
                        int idTransaction = scanner.nextInt();
                        System.out.println("Enter id Drug: ");
                        int idDrug = scanner.nextInt();
                        System.out.println("Enter number of pills: ");
                        int numberOfPills = scanner.nextInt();
                        System.out.println("Enter id Client: ");
                        int idClient = scanner.nextInt();
                        System.out.println("Enter transaction Date: ");
                        String transactionDate = scanner.next();

                        try {
                            DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
                            Date date = dateFormat.parse(transactionDate);
                            transactionService.save(idTransaction, idDrug, numberOfPills, idClient, date);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;
                case 4:
                    System.out.println("Enter id Drug: ");
                    int idDrug = scanner.nextInt();
                    System.out.println(drugService.findById(idDrug));
                    break;
                case 5:
                    System.out.println("Enter id Client: ");
                    int idClient = scanner.nextInt();
                    System.out.println(clientCardService.findById(idClient));
                    break;
                case 6:
                    System.out.println("Enter id Transaction: ");
                    int idTransaction = scanner.nextInt();
                    System.out.println(transactionService.findById(idTransaction));
                    break;
                case 7:
                    System.out.println("Enter id: ");
                    int id = scanner.nextInt();
//                    System.out.println("Enter name: ");
//                    String name = scanner.next();
//                    System.out.println("Enter producer: ");
//                    String producer = scanner.next();
                    System.out.println("Enter price: ");
                    double price = scanner.nextDouble();
//                    System.out.println("Enter recipe: ");
//                    boolean recipe = scanner.nextBoolean();
                    try {
                        drugService.updatePriceDrug(id, price);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 8:
                    System.out.println("Enter id: ");
                    int id2 = scanner.nextInt();
                    System.out.println("Enter last name: ");
                    String lastName = scanner.next();
//                    System.out.println("Enter firstName: ");
//                    String firstName = scanner.next();
//                    System.out.println("Enter CNP: ");
//                    String CNP = scanner.next();
//                    System.out.println("Enter birthday: ");
//                    String birthDate = scanner.next();
//                    System.out.println("Enter inregistration Date: ");
//                    String inregistrationDate = scanner.next();

                    try {
//                        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
//                        Date dateBirth = dateFormat.parse(birthDate);
//                        Date dateRegistration = dateFormat.parse(inregistrationDate);
                        clientCardService.updateLastName(id2, lastName);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 9:
                    System.out.println("Enter id Transaction: ");
                    int idTransaction2 = scanner.nextInt();
//                    System.out.println("Enter id Drug: ");
//                    int idDrug2 = scanner.nextInt();
                    System.out.println("Enter number of pills: ");
                    int numberOfPills = scanner.nextInt();
//                    System.out.println("Enter id Client: ");
//                    int idClient2 = scanner.nextInt();
//                    System.out.println("Enter transaction Date: ");
//                    String transactionDate = scanner.next();

                    try {
//                        DateFormat dateFormat = new SimpleDateFormat("dd.mm.yyyy HH:mm");
//                        Date date = dateFormat.parse(transactionDate);
                        transactionService.updatePriceDrug(idTransaction2, numberOfPills);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 10:
                    System.out.println("Enter id drug: ");
                    int idDelete = scanner.nextInt();
                    drugService.deleteByID(idDelete);
                    System.out.println("Drug deleted");
                    break;
                case 11:
                    System.out.println("Enter id card client");
                    int idDeleteCard = scanner.nextInt();
                    clientCardService.deleteById(idDeleteCard);
                    System.out.println("Card Client deleted");
                    break;
                case 12:
                    System.out.println("Enter id transaction");
                    int idDeleteTransaction = scanner.nextInt();
                    transactionService.deleteByID(idDeleteTransaction);
                    System.out.println("Transaction deleted");
                    break;
                case 13:
                    System.out.println("Enter id transaction");
                    int idPrintTransaction = scanner.nextInt();
                    double discountedPrice = transactionService.printCost(idPrintTransaction, drugService, clientCardService);
                    System.out.println("Discount price: " + discountedPrice);
                    break;
                case 14:
                    System.out.println("Enter text to search:");
                    String searchTextValue = scanner.next();
                    List<Drug> resultsDrugs = drugService.searchFullText(searchTextValue);
                    List<ClientCard> resultsClients = clientCardService.searchFullText(searchTextValue);

                    System.out.println("We identified the following drugs:");
                    for (Drug drug : resultsDrugs) {
                        System.out.println(drug);
                    }

                    System.out.println("We identified the following clients:");
                    for (ClientCard client : resultsClients) {
                        System.out.println(client);
                    }
                    break;

                case 15:
                    System.out.println("Enter starting date for transactions display: ");
                    String startingDate = scanner.next();
                    System.out.println("Enter ending date for transactions display: ");
                    String endingDate = scanner.next();
                    try {
                        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
                        Date dateStart = dateFormat.parse(startingDate);
                        Date dateEnd = dateFormat.parse(endingDate);
                        List<Transaction> resultsTransactions = transactionService.searchIntervalTransactions(dateStart,dateEnd);
                        System.out.println("We identified the following transactions:");
                        for (Transaction t : resultsTransactions){
                            System.out.println(t);
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 16:
                    System.out.println("Enter starting date for transactions display: ");
                    String startingDate2 = scanner.next();
                    System.out.println("Enter ending date for transactions display: ");
                    String endingDate2 = scanner.next();
                    try {
                        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
                        Date dateStart = dateFormat.parse(startingDate2);
                        Date dateEnd = dateFormat.parse(endingDate2);
                       transactionService.deleteIntervalTransactions(dateStart,dateEnd);
                        System.out.println("Transaction deleted");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                    case 17:
                    System.out.println("Enter the target price: ");
                    double targetPrice = scanner.nextDouble();
                    System.out.println("Enter the procent: ");
                    double procent = scanner.nextDouble();
                    List<Drug> drugList = drugService.increasePriceDrug(targetPrice, procent);
                    System.out.println(drugList);
                    break;

                case 18:
                    transactionService.printMostSoldDrugs(drugService);
                    break;

                case 19:
                    List<Map.Entry<Integer, Double>> cardsList = transactionService.sortCardClient(drugService, clientCardService);
                    for (Map.Entry<Integer, Double> entry: cardsList) {
                        ClientCard card = clientCardService.findById(entry.getKey());
                        System.out.println(card + "," + entry.getValue());
                    }
                    break;
            }
        }
    }
}

