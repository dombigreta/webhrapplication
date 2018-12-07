package hu.miskolc.iit.application.Exceptions;

public class WrongGenderException extends  RuntimeException {

    public WrongGenderException()
    {

    }

    public WrongGenderException(String gender)
    {
        super(String.format("The gender you have given is not correct! %s",gender));
    }


    public WrongGenderException(Throwable cause)
    {
        super(cause);
    }

    public WrongGenderException(String message, Throwable cause)
    {
        super(message,cause);
    }
}
