package io.github.ertansidar.exception.handlers;

import io.github.ertansidar.exception.detail.*;
import io.github.ertansidar.exception.type.*;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({BusinessException.class}) //catch
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public BusinessProblemDetails handleBusinessException(BusinessException exception) {
        BusinessProblemDetails problemDetails = new BusinessProblemDetails();
        problemDetails.setDetail(exception.getMessage());
        return problemDetails;
    }

    @ExceptionHandler({BadRequestException.class}) //catch
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public BadRequestProblemDetails handleBadRequestException(BadRequestException exception) {
        BadRequestProblemDetails problemDetails = new BadRequestProblemDetails();
        problemDetails.setDetail(exception.getMessage());
        return problemDetails;
    }

    @ExceptionHandler({ConflictException.class}) //catch
    @ResponseStatus(HttpStatus.CONFLICT)
    public ConflictProblemDetails handleConflictException(ConflictException exception) {
        ConflictProblemDetails problemDetails = new ConflictProblemDetails();
        problemDetails.setDetail(exception.getMessage());
        return problemDetails;
    }

    @ExceptionHandler({AuthorizationException.class}) //catch
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public AuthorizationProblemDetails handleForbiddenException(AuthorizationException exception) {
        AuthorizationProblemDetails problemDetails = new AuthorizationProblemDetails();
        problemDetails.setDetail(exception.getMessage());
        return problemDetails;
    }

    @ExceptionHandler({InternalServerException.class}) //catch
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public InternalServerProblemDetails handleInternalServerException(InternalServerException exception) {
        InternalServerProblemDetails problemDetails = new InternalServerProblemDetails();
        problemDetails.setDetail(exception.getMessage());
        return problemDetails;
    }

    @ExceptionHandler({RateLimitExceededException.class}) //catch
    @ResponseStatus(HttpStatus.TOO_MANY_REQUESTS)
    public RateLimitExceededProblemDetails handleRateLimitException(RateLimitExceededException exception) {
        RateLimitExceededProblemDetails problemDetails = new RateLimitExceededProblemDetails();
        problemDetails.setDetail(exception.getMessage());
        return problemDetails;
    }

    @ExceptionHandler({ResourceNotFoundException.class}) //catch
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResourceNotFoundProblemDetails handleResourceNotFoundException(ResourceNotFoundException exception) {
        ResourceNotFoundProblemDetails problemDetails = new ResourceNotFoundProblemDetails();
        problemDetails.setDetail(exception.getMessage());
        return problemDetails;
    }

    @ExceptionHandler({AuthenticationException.class}) //catch
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public AuthenticationProblemDetails handleUnauthorizedException(AuthenticationException exception) {
        AuthenticationProblemDetails problemDetails = new AuthenticationProblemDetails();
        problemDetails.setDetail(exception.getMessage());
        return problemDetails;
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ValidationProblemDetails handleValidationException(MethodArgumentNotValidException exception) {
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();

        Map<String, String> errorDetails = new HashMap<>();
        for (FieldError error : fieldErrors) {
            errorDetails.put(error.getField(), error.getDefaultMessage());
        }

        ValidationProblemDetails problemDetails = new ValidationProblemDetails();
        problemDetails.setErrors(errorDetails);

        return problemDetails;

    }
}

