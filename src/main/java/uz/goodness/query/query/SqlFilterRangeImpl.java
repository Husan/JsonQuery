package uz.goodness.query.query;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SqlFilterRangeImpl implements SqlFilter {
    private String dateBegin;
    private String dateEnd;
    private String column;
    private static final String operator="range";

    public String convertToSql(){
        return column + " between " + dateBegin +" and " + dateEnd;
    }
    public String toString(){
        return column + " between :" + column + "1 and :" + column + "2";
    }

    @Override
    public void init(Map<String, ?> filter) {
        column       = (String) filter.get("column");
        dateBegin        = (String) ((List<?>)filter.get("value")).get(0);
        dateEnd          = (String) ((List<?>)filter.get("value")).get(1);
        //operator     = (String) filter.get("operator");
    }

    @Override
    public Map<String, Object> getBindParam() {
        return Map.of(column+"1", dateBegin, column+"2", dateEnd);
    }

}
