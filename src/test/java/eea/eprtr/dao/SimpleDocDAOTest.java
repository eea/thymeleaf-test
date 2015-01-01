package eea.eprtr.dao;
 
import java.util.List;
 
import org.springframework.context.support.ClassPathXmlApplicationContext;
 
import eea.eprtr.model.SimpleDoc;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
 
// See http://www.journaldev.com/2593/spring-jdbc-and-jdbctemplate-crud-with-datasource-example-tutorial
public class SimpleDocDAOTest {
 
    @Test
    public void simpleTest() {
        //Get the Spring Context
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-dbtest-config.xml");
         
        //Get the SimpleDocDAO Bean from the context.
        SimpleDocDAO simpledocDAO = ctx.getBean("simpleDocDAO", SimpleDocDAO.class);
         
        //Run some tests for JDBC CRUD operations
        SimpleDoc doc = new SimpleDoc();
        doc.setName("testpage");
        doc.setTitle("Test Page");
        doc.setContent("Java Developer");
         
        //Read
        SimpleDoc doc1 = simpledocDAO.getByName("about");
        assertNotNull(doc1);
         
        //Get All
        List<SimpleDoc> docList = simpledocDAO.getAll();
        assertEquals(3, docList.size());

        //Close Spring Context
        ctx.close();
    }
 
}
