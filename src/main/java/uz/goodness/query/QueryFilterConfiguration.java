package uz.goodness.query;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import uz.goodness.query.*;
import uz.goodness.query.query.*;

import java.util.LinkedHashMap;
import java.util.Map;

@Component
@PropertySource({"classpath:query.properties"})
@Configuration
@Setter
@Getter
/**
 * query.properties file ishlatilgani sababi yaml fileni  PropertySource annotaciya ko'rmaydi!
 * */
public class QueryFilterConfiguration {
    private Map<String, ?> filters;
    private Map<String, ?> datasource;

    public static final Map<String, Class<?>> queryFilterOperationClasses = Map.of("=", SqlFilterEqualsImpl.class, "like", SqlFilterLikeImpl.class, "exists", SqlFilterQueryImpl.class, "range", SqlFilterRangeImpl.class);
    public static final Map<String, Class<?>> queryFieldClasses = Map.of("number", SqlFieldNumberImpl.class, "varchar2", SqlFieldVarchar2Impl.class, "text", SqlFieldVarchar2Impl.class);

    @Bean("queryFiltersClasses")
    @ConfigurationProperties(prefix = "filters")
    public Map<String, ?> getQueryFiltersClasses(){
        Map<String, ?> m = new LinkedHashMap<>();
        return new LinkedHashMap<>();
    }

    @Bean("queryFilterBeanNames")
    public Map<String, String> getQueryFilterBeanNames(){
        Map<String, String> m = new LinkedHashMap<>();
        m.put("=", "sqlFilterDefaultServiceImpl");
        m.put("range", "sqlFilterDefaultServiceImpl");
        m.put("query", "sqlFilterQueryServiceImpl");
        return m;
    }
}