package eea.eprtr.dao;

import java.util.List;

import eea.eprtr.model.LOV;

//CRUD operations
public interface CountryService {

    //Create
    //void save(LOV doc);

    //Read
    LOV getByName(String name);

    //Update
    //void update(LOV doc);

    //Delete
    //void deleteById(int id);

    //Get All
    List<LOV> getAll();
}
