package io.github.ertansidar.exception.detail;

import org.springframework.http.HttpStatus;

public class ConflictProblemDetails extends ProblemDetails {
    public ConflictProblemDetails() {
        setTitle("Conflict");
        setType("http://turkcell.com/exceptions/conflict");
        setStatus(HttpStatus.CONFLICT.toString());
    }
}
