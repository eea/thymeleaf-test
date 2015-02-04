package eea.eprtr.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;

import eea.eprtr.model.LOV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

public class CountryServiceJdbc implements CountryService {

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public LOV getByName(String name) {
        String query = "SELECT LOV_CountryID, Name FROM LOV_COUNTRY"
            + " WHERE Name = ?";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        //using RowMapper anonymous class, we can create a separate RowMapper for reuse
        LOV doc = jdbcTemplate.queryForObject(query, new Object[]{name}, new RowMapper<LOV>(){

            @Override
            public LOV mapRow(ResultSet rs, int rowNum)
                    throws SQLException {
                LOV doc = new LOV(rs.getString("LOV_CountryID"), rs.getString("Name"));
                return doc;
            }});

        return doc;
    }

    @Override
    public List<LOV> getAll() {
        String query = "SELECT LOV_COUNTRY.LOV_CountryID, Name FROM LOV_COUNTRY"
            + " JOIN LOV_COUNTRYAREAGROUP ON LOV_COUNTRY.LOV_CountryID = LOV_COUNTRYAREAGROUP.LOV_CountryID"
            + " WHERE LOV_AreaGroupID=1";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        List<LOV> docList = new ArrayList<LOV>();

        List<Map<String, Object>> docRows = jdbcTemplate.queryForList(query);

        for(Map<String, Object> docRow : docRows){
            LOV doc = new LOV(String.valueOf(docRow.get("ResourceKey")), String.valueOf(docRow.get("ResourceKey")));
            docList.add(doc);
        }
        return docList;
    }

}
