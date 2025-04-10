package io.github.ertansidar.exception.detail;

import org.springframework.http.HttpStatus;

public class ResourceNotFoundProblemDetails extends ProblemDetails {
    public ResourceNotFoundProblemDetails() {
        setTitle("Resource Not Found");
        setType("http://turkcell.com/exceptions/resource-not-found");
        setStatus(HttpStatus.NOT_FOUND.toString());
    }
}
