package io.github.ertansidar.exception.detail;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.Map;

@Getter
@Setter
public class ValidationProblemDetails extends ProblemDetails {

    private Map<String, String> errors;

    public ValidationProblemDetails() {
        setTitle("Validation Exception");
        setType("https://turkcell.com/exceptions/validation");
        setStatus(HttpStatus.BAD_REQUEST.toString());
        setDetail("Validation Rule Problems");
    }
}
