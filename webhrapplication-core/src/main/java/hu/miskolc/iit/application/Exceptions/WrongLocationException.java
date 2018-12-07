package hu.miskolc.iit.application.Exceptions;


public class WrongLocationException extends RuntimeException {
    public WrongLocationException()
    {

    }

    public WrongLocationException(String location)
    {
        super(String.format("The location you have given is not correct! %s",location));
    }


    public WrongLocationException(Throwable cause)
    {
        super(cause);
    }

    public WrongLocationException(String message, Throwable cause)
    {
        super(message,cause);
    }
}