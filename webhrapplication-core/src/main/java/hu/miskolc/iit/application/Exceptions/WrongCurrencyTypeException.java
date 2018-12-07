package hu.miskolc.iit.application.Exceptions;

public class WrongCurrencyTypeException extends RuntimeException {
    public WrongCurrencyTypeException()
    {

    }

    public WrongCurrencyTypeException(String currency)
    {
        super(String.format("The location you have given is not correct! %s",currency));
    }


    public WrongCurrencyTypeException(Throwable cause)
    {
        super(cause);
    }

    public WrongCurrencyTypeException(String message, Throwable cause)
    {
        super(message,cause);
    }
}
