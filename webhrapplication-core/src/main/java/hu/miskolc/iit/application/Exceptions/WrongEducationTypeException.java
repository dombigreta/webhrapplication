package hu.miskolc.iit.application.Exceptions;

public class WrongEducationTypeException extends  RuntimeException {

    public WrongEducationTypeException() {

    }

    public WrongEducationTypeException(String educationLevel) {
        super(String.format("The education level you have given is not correct! %s", educationLevel));
    }


    public WrongEducationTypeException(Throwable cause) {
        super(cause);
    }

    public WrongEducationTypeException(String message, Throwable cause)
    {
        super(message,cause);
    }
}