package eea.eprtr.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;

import eea.eprtr.model.SimpleDoc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

public class SimpleDocServiceJdbc implements SimpleDocService {

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public SimpleDoc getByName(String name) {
        String query = "SELECT ResourceKey, KeyTitle, ResourceValue FROM ReviseResourceKey"
            + " JOIN ReviseResourceValue ON ReviseResourceKey.ResourceKeyID = ReviseResourceValue.ResourceKeyID"
            + " AND CultureCode='en-GB' WHERE ResourceKey = ?";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        //using RowMapper anonymous class, we can create a separate RowMapper for reuse
        SimpleDoc doc = jdbcTemplate.queryForObject(query, new Object[]{name}, new RowMapper<SimpleDoc>(){

            @Override
            public SimpleDoc mapRow(ResultSet rs, int rowNum)
                    throws SQLException {
                SimpleDoc doc = new SimpleDoc();
                doc.setName(rs.getString("ResourceKey"));
                doc.setTitle(rs.getString("KeyTitle"));
                doc.setContent(rs.getString("ResourceValue"));
                return doc;
            }});

        return doc;
    }

    @Override
    public List<SimpleDoc> getAll() {
        String query = "SELECT ResourceKey, KeyTitle, ResourceValue FROM ReviseResourceKey"
            + " JOIN ReviseResourceValue ON ReviseResourceKey.ResourceKeyID = ReviseResourceValue.ResourceKeyID"
            + " AND CultureCode='en-GB'";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        List<SimpleDoc> docList = new ArrayList<SimpleDoc>();

        List<Map<String, Object>> docRows = jdbcTemplate.queryForList(query);

        for(Map<String, Object> docRow : docRows){
            SimpleDoc doc = new SimpleDoc();
            doc.setName(String.valueOf(docRow.get("ResourceKey")));
            doc.setTitle(String.valueOf(docRow.get("KeyTitle")));
            doc.setContent(String.valueOf(docRow.get("ResourceValue")));
            docList.add(doc);
        }
        return docList;
    }

}
