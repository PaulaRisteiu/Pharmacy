package repository;

import domain.Drug;
import domain.Transaction;
import service.TransactionService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DrugRepositoryImpl implements DrugRepository{

    private List<Drug> drugList;

    public DrugRepositoryImpl() {
        drugList = new ArrayList<>();
    }

    @Override
    public List<Drug> findAll() {
        return drugList;
    }

    @Override
    public Drug findById (int id) {
       for (Drug drug: drugList) {
           if (drug.getId() == id) {
               return drug;
           }
       }
       return null;
    }
    @Override
    public void save(Drug drug) {
        if (findById(drug.getId()) != null) {
            throw new RuntimeException("Id already exist");
        }
        drugList.add(drug);
    }
    @Override
    public void update(int id, Drug drug) {
        Drug updateDrug = findById(id);
        if (updateDrug == null) {
            throw new RuntimeException("The drug doesn't exist");
        }
        updateDrug.setPrice(drug.getPrice());
    }
    @Override
    public void deleteById(int id) {
        Drug deleteDrug = findById(id);
        if (deleteDrug == null) {
            throw new RuntimeException("The drug with this id doesn't exist");
        } else {
            drugList.remove(deleteDrug);
        }
    }
    public List<Drug> searchFullText(String searchTextValue) {
        ArrayList<Drug> tempList = new ArrayList<>();
        for (Drug drug : drugList) {
            if (drug.getName().equals(searchTextValue) ||
                    drug.getProducer().equals(searchTextValue) ||
                    Integer.toString(drug.getId()).equals(searchTextValue) ||
                    Double.toString(drug.getPrice()).equals(searchTextValue)
            ) {
                tempList.add(drug);
            }
        }
        return tempList;
    }


}
