package io.github.ertansidar.exception.detail;

public class BusinessProblemDetails extends ProblemDetails {
    public BusinessProblemDetails() {
        setType("https://turkcell.com/exceptions/business");
        setTitle("Business Rule Violation");
        setStatus("400");
    }
}
