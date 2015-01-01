package eea.eprtr.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
 
import javax.sql.DataSource;
 
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
 
import eea.eprtr.model.SimpleDoc;
 
public class SimpleDocDAOJdbc implements SimpleDocDAO {
 
    //@Autowired  
    private DataSource dataSource;
 
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
     
    @Override
    public SimpleDoc getByName(String name) {
        String query = "select NAME, TITLE, CONTENT from PAGES where NAME = ?";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
         
        //using RowMapper anonymous class, we can create a separate RowMapper for reuse
        SimpleDoc doc = jdbcTemplate.queryForObject(query, new Object[]{name}, new RowMapper<SimpleDoc>(){
 
            @Override
            public SimpleDoc mapRow(ResultSet rs, int rowNum)
                    throws SQLException {
                SimpleDoc doc = new SimpleDoc();
                doc.setName(rs.getString("NAME"));
                doc.setTitle(rs.getString("TITLE"));
                doc.setContent(rs.getString("CONTENT"));
                return doc;
            }});
         
        return doc;
    }
 
    @Override
    public List<SimpleDoc> getAll() {
        String query = "select NAME, TITLE, CONTENT from PAGES";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        List<SimpleDoc> docList = new ArrayList<SimpleDoc>();
 
        List<Map<String, Object>> docRows = jdbcTemplate.queryForList(query);
         
        for(Map<String, Object> docRow : docRows){
            SimpleDoc doc = new SimpleDoc();
            doc.setName(String.valueOf(docRow.get("NAME")));
            doc.setTitle(String.valueOf(docRow.get("TITLE")));
            doc.setContent(String.valueOf(docRow.get("CONTENT")));
            docList.add(doc);
        }
        return docList;
    }
 
}
