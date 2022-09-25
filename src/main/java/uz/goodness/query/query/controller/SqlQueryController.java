package uz.goodness.query.query.controller;

import lombok.SneakyThrows;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import uz.goodness.query.query.SqlQueryImpl;
//import uz.goodness.query.security.annotation.CheckPermission;

import java.util.Map;

public interface SqlQueryController {
    @SneakyThrows
    @PostMapping("user/datatable")
    //@CheckPermission(value="Test HelloWorld!")
    ResponseEntity<String> dataTable(@RequestBody Map<String, ?> json/*, @AuthenticationPrincipal UserDetails authentication*/);

    @SneakyThrows
    @PostMapping("/api/public/queryC")
    //@CheckPermission(value="Test HelloWorld!")
    ResponseEntity<String> dataTableC(@RequestBody SqlQueryImpl sqlQuery/*, @AuthenticationPrincipal UserDetails authentication*/);
}
