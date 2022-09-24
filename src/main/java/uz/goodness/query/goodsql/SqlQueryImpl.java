package uz.goodness.query.goodsql;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
@Setter
public class SqlQueryImpl implements SqlQuery {
    private String id ;
    private String source;
    private List<SqlField> sqlFields = new ArrayList<>();
    private List<SqlFilter> sqlFilters= new ArrayList<>();

    public SqlQueryImpl(Map<String, ?> json){
        var query = (Map<String, ?>) json.get("query");

        source = (String) query.get("source");
        List<Map<String, ?>> fields = (List<Map<String, ?>>) query.get("fields");
        fields.forEach(map -> {sqlFields.add(SqlField.create(map));});


        List<Map<String, ?>> filters = (List<Map<String, ?>>) query.get("filters");
        filters.forEach(map -> {sqlFilters.add(SqlFilter.create(map));});
    }


    @Override
    public String toString() {
        return "select " + sqlFields.stream().map(SqlField::toString).collect(Collectors.joining(", ", "", "")) +
                " from " + source + " " +
                sqlFilters.stream().map(SqlFilter::toString).collect(Collectors.joining(" and ", " where ", ""));
    }
}
