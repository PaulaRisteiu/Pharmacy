package service;

import domain.ClientCard;
import domain.Drug;
import repository.ClientCardRepository;
import repository.ClientCardRepositoryImpl;

import java.util.Date;
import java.util.List;

public class ClientCardService {

    private ClientCardRepository clientCardRepository;

    public ClientCardService() {
        this.clientCardRepository = new ClientCardRepositoryImpl();
    }

    public void save(int id, String lastName, String firstName, String CNP, Date birthDate, Date inregistrationDate) {

     ClientCard clientCard = new ClientCard(id, lastName, firstName, CNP, birthDate, inregistrationDate);
        clientCardRepository.save(clientCard);
    }

    public ClientCard findById(int id) {
        return clientCardRepository.findById(id);
    }

    public void updateLastName(int idUpdate, String lastName){
        ClientCard clientCard = new ClientCard();
        clientCard.setId(idUpdate);
        clientCard.setLastName(lastName);
        clientCardRepository.update(idUpdate,clientCard);
    }

    public void deleteById(int id) {
        clientCardRepository.deleteById(id);
    }

    public List<ClientCard> searchFullText(String searchTextValue) {
        return this.clientCardRepository.searchFullText(searchTextValue);
    }
}
