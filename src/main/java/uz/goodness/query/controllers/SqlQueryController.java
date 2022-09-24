package uz.goodness.query.controllers;

import lombok.SneakyThrows;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

public interface SqlQueryController {
    @SneakyThrows
    @PostMapping("/api/public/query")
    ResponseEntity<String> queryExec(Map<String, ?> map);
}
