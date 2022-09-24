package uz.goodness.query.goodsql;

import lombok.SneakyThrows;

import java.util.Map;

public interface SqlField {
    void init(Map<String, ?> field);

    @SneakyThrows
    static SqlField create(Map<String, ?> field){
        String type = (String) field.get("type");

        //SqlField sqlField = (SqlField) SqlQueryOperationMap.queryFieldTypeClasses.get(type).getDeclaredConstructor().newInstance();
        //if(type.equals("number"))sqlField = new SqlFieldNumberImpl();

        SqlField sqlField = (SqlField) SqlQueryOperationMap.queryFieldTypeClasses.get(type).getDeclaredConstructor().newInstance();
        sqlField.init(field);
        return sqlField;
    }



}
