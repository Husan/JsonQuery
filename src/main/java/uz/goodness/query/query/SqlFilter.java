package uz.goodness.query.query;

import lombok.SneakyThrows;
import uz.goodness.query.QueryFilterConfiguration;

import java.util.Map;

public interface SqlFilter {
    void init(Map<String, ?> filter);
    Map<String, Object> getBindParam();

    @SneakyThrows
    static SqlFilter create(Map<String, ?> filter){
        String operator     = (String) filter.get("operator");
        SqlFilter sqlFilter = (SqlFilter) QueryFilterConfiguration.queryFilterOperationClasses.get(operator).getDeclaredConstructor().newInstance();
        sqlFilter.init(filter);
        return sqlFilter;
    };
}