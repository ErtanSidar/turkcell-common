package io.github.ertansidar.exception.type;


public class InternalServerException extends InternalError {
    public InternalServerException(String message){
        super(message);
    }
}
