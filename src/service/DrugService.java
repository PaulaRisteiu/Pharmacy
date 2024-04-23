package service;

import domain.Drug;
import domain.Transaction;
import repository.DrugRepository;
import repository.DrugRepositoryImpl;

import java.util.ArrayList;
import java.util.List;

public class DrugService {
    private DrugRepository drugRepository;

    public DrugService() {
        this.drugRepository = new DrugRepositoryImpl();
    }
    public void save(int id, String name, String producer, double price, boolean recipe) {
        if (price <= 0) {
            throw new RuntimeException("Invalid price");
        }
            Drug drug = new Drug(id, name, producer, price, recipe);
            drugRepository.save(drug);
        }
        public Drug findById(int id) {
        return drugRepository.findById(id);
        }

    public void updatePriceDrug(int idUpdate, double price){
        if (price <= 0) {
            throw new RuntimeException("Invalid price");
        }
        Drug drug = new Drug();
        drug.setId(idUpdate);
        drug.setPrice(price);
        drugRepository.update(idUpdate, drug);
    }

    public void deleteByID(int id){
        drugRepository.deleteById(id);

    }
    public List<Drug> searchFullText(String searchTextValue) {
        return this.drugRepository.searchFullText(searchTextValue);
    }

    //Scumpirea cu un procentaj dat a tuturor medicamentelor cu prețul mai mic decât o valoare dată.
    public List<Drug> increasePriceDrug(double price, double procent) {
       List<Drug> drugList = drugRepository.findAll();
        for (Drug checkDrug : drugList){
            if (checkDrug.getPrice() <= price) {
                checkDrug.setPrice(checkDrug.getPrice() + (checkDrug.getPrice() * (procent / 100)) );
            }
        }
        return drugList;
    }

}
