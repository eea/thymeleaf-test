package eea.eprtr.dao;

import java.util.List;

import eea.eprtr.model.SimpleDoc;

//CRUD operations
public interface SimpleDocService {

    //Create
    //void save(SimpleDoc doc);

    //Read
    SimpleDoc getByName(String name);

    //Update
    //void update(SimpleDoc doc);

    //Delete
    //void deleteById(int id);

    //Get All
    List<SimpleDoc> getAll();
}
