package uz.goodness.query.goodsql;

import lombok.SneakyThrows;

import java.util.Map;

public interface SqlFilter {
    void init(Map<String, ?> filter);

    @SneakyThrows
    static SqlFilter create(Map<String, ?> filter){
        String operator = (String) filter.get("operator");
        SqlFilter sqlFilter = (SqlFilter) SqlQueryOperationMap.queryFilterTypeClasses.get(operator).getDeclaredConstructor().newInstance();
        sqlFilter.init(filter);

        return sqlFilter;
    }
}
