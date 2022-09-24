package uz.goodness.query.sql;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class SqlController {


    @PostMapping("/api/query")
    public ResponseEntity<String> createSql(@RequestBody Map<String, ?> json){
        SqlQueryImpl sqlQuery = new SqlQueryImpl();

        String res = SqlQueryImpl.create((LinkedHashMap<String, ?>) json);

        return ResponseEntity.ok().body(res);
    }

}
