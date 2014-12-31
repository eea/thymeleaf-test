package eea.eprtr.dao;
 
import java.util.List;
 
import eea.eprtr.model.SimpleDoc;
 
//CRUD operations
public interface SimpleDocDAO {
     
    //Create
    //public void save(SimpleDoc doc);
    //Read
    public SimpleDoc getByName(String name);
    //Update
    //public void update(SimpleDoc doc);
    //Delete
    //public void deleteById(int id);
    //Get All
    public List<SimpleDoc> getAll();
}
