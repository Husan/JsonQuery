package uz.goodness.query.goodsql;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;


@Getter
@Setter
public class SqlFieldVarcharImpl implements SqlField {

    private String name;
    private String format;
    private String type;


    @Override
    public void init(Map<String, ?> field) {
        this.name = (String) field.get("name");
        this.format = (String) field.get("format");
        this.type = (String) field.get("type");
    }

    @Override
    public String toString() {
        return name;
    }
}
