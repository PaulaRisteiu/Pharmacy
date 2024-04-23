import UI.Consola;
import domain.ClientCard;
import domain.Drug;
import repository.*;
import service.ClientCardService;
import service.DrugService;
import service.TransactionService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Consola consola = new Consola();
        consola.runMenu();


//        ClientCardRepository clientCardRepository = new ClientCardRepositoryImpl();
//        DrugRepository drugRepository = new DrugRepositoryImpl();
//        TransactionRepository transactionRepository = new TransactionRepositoryImpl();
//
//        DrugService drugService = new DrugService();
//        ClientCardService clientCardService = new ClientCardService();
//        TransactionService transactionService = new TransactionService();

      // Consola menu = new Consola(drugService, transactionService, clientCardService);

//        clientCardRepository.save(new ClientCard(1, "John", "Doe", 1, LocalDate.of(1990, 5, 15), LocalDate.now()));
//        clientCardRepository.save(new ClientCard(2, "Alice", "Smith", 2, LocalDate.of(1985, 8, 20), LocalDate.now()));
//        clientCardRepository.save(new ClientCard(3, "Bob", "Johnson", 3, LocalDate.of(1975, 12, 10), LocalDate.now()));
//        drugRepository.save(new Drug(1, "Paracetamol", "Zentiva", 4.7, false));
//        drugRepository.save(new Drug(2, "Algocalmin", "Terapia", 9.90, true));
//        drugRepository.save(new Drug(3, "Aspirina", "Sandoz", 7.77, false));
//        transactionService.save(1, 1, 20, LocalDateTime.of(2024, 4, 6, 12, 30));
//        transactionService.save(2, 1, 30, LocalDateTime.of(2024, 4, 6, 13, 30));
//        transactionService.save(3, 1, 28, LocalDateTime.of(2024, 4, 6, 14, 30));
    }
}