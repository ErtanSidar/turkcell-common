package io.github.ertansidar.exception.detail;

import org.springframework.http.HttpStatus;

public class RateLimitExceededProblemDetails extends ProblemDetails {
    public RateLimitExceededProblemDetails() {
        setTitle("Rate Limit Exceeded");
        setType("http://turkcell.com/exceptions/rate-limit-exceeded");
        setStatus(HttpStatus.TOO_MANY_REQUESTS.toString());
    }
}

