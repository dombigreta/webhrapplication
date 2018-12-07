package hu.miskolc.iit.application.Exceptions;

public class ApplicantIsNotFoundException extends RuntimeException {

    public ApplicantIsNotFoundException() {

    }

    public ApplicantIsNotFoundException(String message) {
        super(message);
    }

    public ApplicantIsNotFoundException(int id) {
        super(String.format("The applicant by id = %d is not found", id));
    }

    public ApplicantIsNotFoundException(Throwable cause) {
        super(cause);
    }

    public ApplicantIsNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
