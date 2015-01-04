package eea.eprtr.dao;

import java.util.List;

import eea.eprtr.model.FacilityName;

//CRUD operations
public interface FacilityService {

    //Create
    //void save(FacilityName facility);

    //Read
    FacilityName getByCode(String code);

    //Update
    //void update(FacilityName facility);

    //Delete
    //public void deleteByCode(String code);

    //Get All
    List<FacilityName> getAll();
}
