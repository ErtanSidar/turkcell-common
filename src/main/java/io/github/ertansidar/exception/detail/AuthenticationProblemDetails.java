package io.github.ertansidar.exception.detail;

import org.springframework.http.HttpStatus;

public class AuthenticationProblemDetails extends ProblemDetails {
    public AuthenticationProblemDetails() {
        setTitle("Not Authenticated");
        setType("http://turkcell.com/exceptions/notauthenticated");
        setStatus(HttpStatus.UNAUTHORIZED.toString());
    }
}
