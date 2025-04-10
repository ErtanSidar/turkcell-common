package io.github.ertansidar.exception.detail;

import org.springframework.http.HttpStatus;

public class BusinessProblemDetails extends ProblemDetails {
    public BusinessProblemDetails() {
        setType("https://turkcell.com/exceptions/business");
        setTitle("Business Rule Violation");
        setStatus(HttpStatus.BAD_REQUEST.toString());
    }
}
