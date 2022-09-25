package uz.goodness.query.query;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class SqlFieldVarchar2Impl implements SqlField {
    private String name;
    private String format;
    private String type;


    @Override
    public void init(Map<String, ?> field){
        this.name     = (String) field.get("column");
        this.type     = (String) field.get("type");
        this.format   = (String) field.get("format");
    };

    @Override
    public String toString() {
        return name;
    }
}
