package uz.goodness.query.goodsql;

import java.util.Map;

public class SqlFilterQueryImpl implements SqlFilter {

    private SqlQuery query;
    private String column;

    @Override
    public void init(Map<String, ?> filter) {
        query  = new SqlQueryImpl(filter);
        column = (String) filter.get("column");
    }

    @Override
    public String toString() {
        return " exists ("+ query.toString() +")";
    }
}
