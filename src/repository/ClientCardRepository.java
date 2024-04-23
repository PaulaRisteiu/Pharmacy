package repository;

import domain.ClientCard;
import domain.Drug;

import java.util.List;

public interface ClientCardRepository {

    List<ClientCard> findAll(); //read all
    ClientCard findById(int id); //read by id
    void save(ClientCard clientCard); //
    void update(int id, ClientCard clientCard);
    void deleteById(int id);

    List<ClientCard> searchFullText(String searchTextValue);
}
