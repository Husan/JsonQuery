package uz.goodness.query.sql;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SqlQueryImpl implements SqlQuery {

    private String source;
    //private List<SqlField> fields;
    //private List<SqlFilter> filters;

    @SneakyThrows
    static String create(LinkedHashMap<String, ?> map){
        String source = (String) map.get("source");

        List<Map<String, ?>> fields = (List<Map<String, ?>>) map.get("fields");
        List<Map<String, ?>> filters = (List<Map<String, ?>>) map.get("filters");

        List<String> fieldStrArr = new ArrayList<>();
        for(Map<String, ?> field:fields){
            String fieldColumn   = (String) field.get("column");
            String fieldType     = (String) field.get("type");
            String fieldFormat   = (String) field.get("format");

            if(fieldType.equals("number")){
                fieldStrArr.add("to_number("+fieldColumn+",'fm999999999990D90')");
            }
            if(fieldType.equals("text")){
                fieldStrArr.add(fieldColumn);
            }
            if(fieldType.equals("date")){
                fieldStrArr.add("to_date("+fieldColumn+",'dd.mm.yyyy')");
            }

        }



        List<String> filtersStrArr = new ArrayList<>();
        for(Map<String, ?> filter:filters){
            String column       = (String) filter.get("column");
            String operator     = (String) filter.get("operator");
            Object value        = filter.get("value");

            if(operator.equals("=")){
                filtersStrArr.add(column + " = " + value);
            }
            if(operator.equals("range")){
                ArrayList values = (ArrayList) value;
                filtersStrArr.add(column + " between " + values.get(0) + " and " + values.get(1));
            }
            if(operator.equals("like")){
                filtersStrArr.add(column + " like " + value);
            }
        }

        String result = "select " + fieldStrArr.toString() + " from " + source + " where " + filtersStrArr.toString();

        return result;
    }
}
