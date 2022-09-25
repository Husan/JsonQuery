package uz.goodness.query.query;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SqlSourceImpl implements SqlSource {
    private String source;
    @Override
    public String toString(){
        return (source.contains("select ")?"("+source+")":source);
    }
}
