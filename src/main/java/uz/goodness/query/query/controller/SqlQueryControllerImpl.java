package uz.goodness.query.query.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import uz.goodness.query.QueryFilterConfiguration;
import uz.goodness.query.query.SqlQuery;
import uz.goodness.query.query.SqlQueryImpl;
import uz.goodness.query.query.repository.SqlQueryRepository;

import java.util.Map;

@RestController
@CrossOrigin(origins = {"http://192.168.44.2:3001", "http://192.168.44.147:3001", "http://localhost:3001"}, allowedHeaders = {"*"}, exposedHeaders = {"*"})
@Slf4j
public class SqlQueryControllerImpl implements SqlQueryController {

    @Autowired
    QueryFilterConfiguration filterConfiguration;

    @Autowired
    SqlQueryRepository sqlQueryRepository;

    @Autowired
    ObjectMapper objectMapper;

    @Override
    @SneakyThrows
    @PostMapping("/api/public/query")
    //@CheckPermission(value="Test HelloWorld!")
    public ResponseEntity<String> dataTable(@RequestBody Map<String, ?> json/*, @AuthenticationPrincipal UserDetails authentication*/){
        log.info("Json = {}", json);
        SqlQuery sqlQuery = new SqlQueryImpl(json);
        log.info("result = {}", sqlQuery);
        return ResponseEntity.ok().body(objectMapper.writeValueAsString(sqlQueryRepository.executeSql(sqlQuery)));
    }

    @Override
    @SneakyThrows
    @PostMapping("/api/public/queryC")
    //@CheckPermission(value="Test HelloWorld!")
    public ResponseEntity<String> dataTableC(@RequestBody SqlQueryImpl sqlQuery/*, @AuthenticationPrincipal UserDetails authentication*/){
        log.info("Json = {}", sqlQuery);
        /*SqlQuery sqlQuery = new SqlQueryImpl(json);*/
        return ResponseEntity.ok().body(sqlQuery.toString());
    }
}
