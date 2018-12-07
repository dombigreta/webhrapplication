package hu.miskolc.iit.application.Exceptions;

public class WrongCareerTypeException extends RuntimeException {
    public WrongCareerTypeException()
    {

    }

    public WrongCareerTypeException(String career)
    {
        super(String.format("The location you have given is not correct! %s",career));
    }


    public WrongCareerTypeException(Throwable cause)
    {
        super(cause);
    }

    public WrongCareerTypeException(String message, Throwable cause)
    {
        super(message,cause);
    }
}