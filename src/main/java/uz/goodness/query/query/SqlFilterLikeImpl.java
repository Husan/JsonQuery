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
public class SqlFilterLikeImpl<T> implements SqlFilter {
    private T value;
    private String column;

    public String convertToSql(){
        return column + " like " + value;
    }
    public String toString(){
        return column + " like :" + column;
    }

    @Override
    public void init(Map<String, ?> filter) {
        column       = (String) filter.get("column");
        value        = (T) filter.get("value");
        //operator     = (String) filter.get("operator");
    }

    @Override
    public Map<String, Object> getBindParam() {
        return Map.of(column, value);
    }

}
