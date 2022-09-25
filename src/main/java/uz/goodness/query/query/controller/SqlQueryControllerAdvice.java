package uz.goodness.query.query.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import uz.goodness.query.exceptions.ResourceNotFoundException;

import java.sql.SQLException;

@RestControllerAdvice({"uz.goodness.query.query"})
public class SqlQueryControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handleResourceNotFoundException(
            ResourceNotFoundException resourceNotFoundException,
            WebRequest webRequest)
    {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resourceNotFoundException.toString());
    }

    @ExceptionHandler(SQLException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handleSQLException(
            SQLException sqlException,
            WebRequest webRequest)
    {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(sqlException.toString());
    }
}
