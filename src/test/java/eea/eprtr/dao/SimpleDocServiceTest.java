package eea.eprtr.dao;
 
import java.util.List;
 
import org.springframework.context.support.ClassPathXmlApplicationContext;
 
import eea.eprtr.model.SimpleDoc;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;
 
// See http://www.journaldev.com/2593/spring-jdbc-and-jdbctemplate-crud-with-datasource-example-tutorial
public class SimpleDocServiceTest {
 
    @Test
    public void simpleTest() {
        //Get the Spring Context
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-dbtest-config.xml");
         
        //Get the SimpleDocService Bean from the context.
        SimpleDocService simpledocService = ctx.getBean("simpleDocService", SimpleDocService.class);
         
        //Run some tests for JDBC CRUD operations
        SimpleDoc doc = new SimpleDoc();
        doc.setName("testpage");
        doc.setTitle("Test Page");
        doc.setContent("Java Developer");
         
        //Read
        SimpleDoc doc1 = simpledocService.getByName("about");
        assertNotNull(doc1);
         
        //Get All
        List<SimpleDoc> docList = simpledocService.getAll();
        assertTrue(docList.size() > 0);

        //Close Spring Context
        ctx.close();
    }
 
}
