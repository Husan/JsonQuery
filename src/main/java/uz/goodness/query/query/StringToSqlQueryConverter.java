package uz.goodness.query.query;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class StringToSqlQueryConverter implements Converter<String, SqlQueryImpl> {
    @Autowired
    ObjectMapper objectMapper;

    @Override
    public SqlQueryImpl convert(String source) {
        Map<String, ?> map = objectMapper.convertValue(source, Map.class);
        return new SqlQueryImpl(map);
    }
}
