package repository;

import domain.ClientCard;
import domain.Drug;
import domain.Transaction;

import java.util.ArrayList;
import java.util.List;

public class ClientCardRepositoryImpl implements ClientCardRepository{

    private List<ClientCard> clientCardList;

    public ClientCardRepositoryImpl() {
        this.clientCardList = new ArrayList<>();
    }

    @Override
    public List<ClientCard> findAll() {
        return clientCardList;
    }

    @Override
    public ClientCard findById(int id) {
        for (ClientCard clientCard: clientCardList) {
            if (clientCard.getId() == id) {
                return clientCard;
            }
        }
        return null;
    }
    public ClientCard findByCNP(String CNP) {
        for (ClientCard clientCard: clientCardList){
            if (clientCard.getCNP().equals(CNP)){
                return clientCard;
            }
        }
        return null;
    }
    @Override
    public void save(ClientCard clientCard) {
        if (findById(clientCard.getId()) != null) {
            throw new RuntimeException("Id already exist");
        }
        if (findByCNP(clientCard.getCNP())!= null) {
            throw  new RuntimeException("CNP already exist");
        }
        clientCardList.add(clientCard);
    }

    @Override
    public void update(int id, ClientCard clientCard) {
       ClientCard updateClientCard = findById(id);
        if (updateClientCard == null) {
            throw new RuntimeException("The drug doesn't exist");
        }
        updateClientCard.setLastName(clientCard.getLastName());
    }

    @Override
    public void deleteById(int id) {
            ClientCard deleteClientCard = findById(id);
            if (deleteClientCard == null) {
                throw new RuntimeException("The drug with this id doesn't exist");
            } else {
                clientCardList.remove(deleteClientCard);
            }
        }

    public List<ClientCard> searchFullText(String searchTextValue) {
        ArrayList<ClientCard> tempList = new ArrayList<>();
        for (ClientCard clientCard : clientCardList) {
            if (clientCard.getCNP().equals(searchTextValue) ||
                    clientCard.getLastName().equals(searchTextValue) ||
                    clientCard.getFirstName().equals(searchTextValue) ||
                    Integer.toString(clientCard.getId()).equals(searchTextValue)
            ) {
                tempList.add(clientCard);
            }
        }
        return tempList;
    }
}
