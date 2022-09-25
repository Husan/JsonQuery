package uz.goodness.query.query;

import lombok.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SqlQueryImpl implements SqlQuery {
    private SqlSource  source;
    private List<SqlField> sqlFields;
    private List<SqlFilter> sqlFilters;

    @SneakyThrows
    public SqlQueryImpl(Map<String, ?> source){
        sqlFields = new ArrayList<>();
        sqlFilters = new ArrayList<>();

        var query = (Map<String, ?>) source.get("query");
        SqlSource querySource = new SqlSourceImpl((String) query.get("source"));
        this.setSource(querySource);

        /**
         * Method javadoc
         *Initializing <h1>fields</h1> of query
         * */
        List<Map<String, ?>> fields = (List<Map<String, ?>>) (query.get("fields"));
        fields.forEach(field -> sqlFields.add(SqlField.create(field)));
        /**
         *Initializing filters of query
         * */
        List<Map<String, ?>> filters = (List<Map<String, ?>>) (query.get("filters"));
        if(filters!=null) filters.forEach(filter->sqlFilters.add(SqlFilter.create(filter)));
    }

    /**
     * If this will be not necessary in future this method will be removed!!!
     * */
    @SneakyThrows
    public static SqlQuery createQuery(Map<String, ?> source){
        SqlQueryImpl sqlQuery = new SqlQueryImpl();
        sqlQuery.setSqlFields(new ArrayList<>());
        sqlQuery.setSqlFilters(new ArrayList<>());

        var query = (Map<String, ?>) source.get("query");
        SqlSource querySource = new SqlSourceImpl((String) query.get("source"));
        String queryId     = (String) query.get("id");
        sqlQuery.setSource(querySource);

        /**
         *Initializing fields of query
         * */
        List<Map<String, ?>> fields = (List<Map<String, ?>>) (query.get("fields"));
        fields.forEach(field -> sqlQuery.getSqlFields().add(SqlField.create(field)));
        /**
         *Initializing filters of query
         * */
        List<Map<String, ?>> filters = (List<Map<String, ?>>) (query.get("filters"));
        filters.forEach(filter->sqlQuery.getSqlFilters().add(SqlFilter.create(filter)));

        return sqlQuery;
    }

    @Override
    public Map<String, ?> getBindParams(){
        Map<String, Object> res = new LinkedHashMap<>();
        for (SqlFilter sqlFilter : sqlFilters) {
            res.putAll(sqlFilter.getBindParam());
        }
        return res;
    }

    @Override
    public String toString(){
        return "select " + sqlFields.stream().map(SqlField::toString).collect(Collectors.joining(", ", "", "")) +
                " from " + source.toString() +
                (sqlFilters.size()!=0?sqlFilters.stream().map(SqlFilter::toString).collect(Collectors.joining(" and ", " where ", "")):"");
    }
}