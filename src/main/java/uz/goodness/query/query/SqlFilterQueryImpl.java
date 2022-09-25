package uz.goodness.query.query;

import lombok.*;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SqlFilterQueryImpl implements SqlFilter {
    private static final String operation="exists";
    private SqlQuery query;
    private String column;

    public String convertToSql(){
        return " exists (" + query.toString() + ")";
    }
    public String toString(){
        return " exists (" + query.toString() + ")";
    }


    @Override
    public void init(Map<String, ?> filter) {
        query        = new SqlQueryImpl(filter);//.createQuery(filter);
        column       = (String) filter.get("column");
    }

    @Override
    public Map<String, Object> getBindParam() {
        return Map.copyOf(query.getBindParams());
    }




}
