package uz.goodness.query.controllers;


import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import uz.goodness.query.goodsql.SqlQueryImpl;

import java.util.Map;

@RestController
@Slf4j
public class SqlQueryControllerImpl implements SqlQueryController {

    @Override
    @SneakyThrows
    @PostMapping("/api/public/query")
    public ResponseEntity<String> queryExec(@RequestBody Map<String, ?> map){
        SqlQueryImpl query = new SqlQueryImpl(map);
        log.info("Sql = {}", query);

        //query.create((Map<String, ?>) map.get("query"));
        return ResponseEntity.ok(query.toString());
    }
}
