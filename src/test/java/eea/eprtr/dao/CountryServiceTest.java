package eea.eprtr.dao;
 
import java.util.List;
 
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
 
import javax.sql.DataSource;
import eea.eprtr.model.LOV;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;
import org.unitils.UnitilsJUnit4;
import org.unitils.dbunit.annotation.DataSet;
import org.unitils.database.annotations.TestDataSource;
 
// See http://www.journaldev.com/2593/spring-jdbc-and-jdbctemplate-crud-with-datasource-example-tutorial
@DataSet("seed-countries.xml")
public class CountryServiceTest extends UnitilsJUnit4 {
 
    @TestDataSource
    private DataSource dataSource;

    private CountryServiceJdbc countryService;

    @Before
    public void setUp() {
        countryService = new CountryServiceJdbc();
        countryService.setDataSource(dataSource);
    }

    @Test
    public void simpleTest() {
        //Get the Spring Context
        //ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-dbtest-config.xml");
         
        //Get the CountryService Bean from the context.
        //CountryService countryService = ctx.getBean("countryService", CountryService.class);
         
        //Read
        LOV doc1 = countryService.getByName("Denmark");
        assertNotNull(doc1);
        assertEquals("59", doc1.getCode());
         
        //Get All
        List<LOV> docList = countryService.getAll();
        assertTrue(docList.size() > 0);

        //Close Spring Context
        //ctx.close();
    }
 
}
