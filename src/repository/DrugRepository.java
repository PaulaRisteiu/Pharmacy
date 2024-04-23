package repository;

import domain.Drug;

import java.util.ArrayList;
import java.util.List;

public interface DrugRepository {
    List<Drug> findAll(); //read all
    Drug findById(int id); //read by id
    void save(Drug drug); //
    void update(int id, Drug drug);
    void deleteById(int id);

    List<Drug> searchFullText(String searchTextValue);
}
