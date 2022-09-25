package uz.goodness.query.query;

import lombok.SneakyThrows;
import uz.goodness.query.QueryFilterConfiguration;

import java.util.Map;

public interface SqlField {
    void init(Map<String, ?> field);

    @SneakyThrows
    static SqlField create(Map<String, ?> field){
        String type       = (String) field.get("type");
        SqlField sqlField = (SqlField) QueryFilterConfiguration.queryFieldClasses.get(type).getDeclaredConstructor().newInstance();
        sqlField.init(field);
        return sqlField;
    };
}
