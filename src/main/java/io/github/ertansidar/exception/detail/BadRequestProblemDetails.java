package io.github.ertansidar.exception.detail;

import org.springframework.http.HttpStatus;

public class BadRequestProblemDetails extends ProblemDetails {
    public BadRequestProblemDetails() {
        setTitle("Bad Request");
        setType("http://turkcell.com/exceptions/bad-request");
        setStatus(HttpStatus.BAD_REQUEST.toString());
    }
}
