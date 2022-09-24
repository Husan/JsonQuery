package uz.goodness.query.goodsql;

import java.util.Map;

public class SqlFilterEqualsImpl<T> implements SqlFilter {

    private String column;
    private static final String operator = "=";
    private T value;

    @Override
    public void init(Map<String, ?> filter) {
        column = (String) filter.get("column");
        value  = (T) filter.get("value");
    }

    @Override
    public String toString() {
        return column + "= :" + column;
    }
}
