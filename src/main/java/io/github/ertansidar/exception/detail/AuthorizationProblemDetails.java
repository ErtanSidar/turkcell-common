package io.github.ertansidar.exception.detail;

import org.springframework.http.HttpStatus;

public class AuthorizationProblemDetails extends ProblemDetails {
    public AuthorizationProblemDetails() {
        setTitle("Not Authorized");
        setType("http://turkcell.com/exceptions/notauthorized");
        setStatus(HttpStatus.FORBIDDEN.toString());
    }
}
