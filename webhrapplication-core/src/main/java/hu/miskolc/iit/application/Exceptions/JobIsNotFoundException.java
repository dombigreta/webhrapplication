package hu.miskolc.iit.application.Exceptions;

public class JobIsNotFoundException extends RuntimeException {

    public JobIsNotFoundException()
    {

    }

    public JobIsNotFoundException(String message)
    {
        super(message);
    }

    public JobIsNotFoundException(int Id)
    {
        super(String.format("The job by id = %d is not found",  Id));
    }

    public JobIsNotFoundException(Throwable cause)
    {
        super(cause);
    }

    public JobIsNotFoundException(String message, Throwable cause)
    {
        super(message,cause);
    }
}