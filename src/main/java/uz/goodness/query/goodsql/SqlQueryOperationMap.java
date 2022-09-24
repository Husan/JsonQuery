package uz.goodness.query.goodsql;

import java.util.Map;

public class SqlQueryOperationMap {

    public static final Map<String, Class<?>> queryFieldTypeClasses = Map.of("number", SqlFieldNumberImpl.class, "varchar", SqlFieldVarcharImpl.class);
    public static final Map<String, Class<?>> queryFilterTypeClasses = Map.of("equals", SqlFilterEqualsImpl.class, "exists", SqlFilterQueryImpl.class);
}
