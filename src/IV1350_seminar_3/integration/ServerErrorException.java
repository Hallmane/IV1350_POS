package IV1350_seminar_3.integration;

public class ServerErrorException extends RuntimeException {
    private boolean serverError = false;
    /**
     * Hard coded exception class for the case when a server cannot be reached
     */
    public ServerErrorException() {
        super("404 - server not found. ");
        serverError = true;
    }
    public boolean isServerErrorExceptionHandled() {
        return serverError;
    }
}
