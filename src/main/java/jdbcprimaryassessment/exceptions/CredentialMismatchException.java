package jdbcprimaryassessment.exceptions;

public class CredentialMismatchException extends Exception {
    public CredentialMismatchException() {
        super("Credentials provided do not match any records.");
    }

    public CredentialMismatchException(String message) {
        super(message);
    }

    public CredentialMismatchException(String message, Throwable cause) {
        super(message, cause);
    }

    public CredentialMismatchException(Throwable cause) {
        super(cause);
    }
}
