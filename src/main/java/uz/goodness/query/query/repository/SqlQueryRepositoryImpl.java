package uz.goodness.query.query.repository;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import uz.goodness.query.query.SqlQuery;

import java.util.List;
import java.util.Map;

@Repository
public class SqlQueryRepositoryImpl implements SqlQueryRepository {

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @Autowired
    NamedParameterJdbcOperations namedParameterJdbcOperations;

    @Override
    @SneakyThrows
    public List<Map<String, Object>> executeSql(SqlQuery sql){
        String query = sql.toString();
        Map<String, ?> params = sql.getBindParams();
        List<Map<String, Object>> res;
        res = namedParameterJdbcTemplate.queryForList(query, params);
        return res;
    }
}
