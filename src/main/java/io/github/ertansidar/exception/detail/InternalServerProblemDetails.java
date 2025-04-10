package io.github.ertansidar.exception.detail;

import org.springframework.http.HttpStatus;

public class InternalServerProblemDetails extends ProblemDetails {
    public InternalServerProblemDetails(){
        setTitle("Internal Server Error");
        setType("http://turkcell.com/exceptions/internalservererror");
        setStatus(HttpStatus.INTERNAL_SERVER_ERROR.toString());
    }
}