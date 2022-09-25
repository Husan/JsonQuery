package uz.goodness.query.query.repository;

import lombok.SneakyThrows;
import uz.goodness.query.query.SqlQuery;

import java.util.List;
import java.util.Map;

public interface SqlQueryRepository {
    @SneakyThrows
    List<Map<String, Object>> executeSql(SqlQuery sql);
}
