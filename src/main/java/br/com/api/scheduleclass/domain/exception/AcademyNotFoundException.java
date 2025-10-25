package br.com.api.scheduleclass.domain.exception;

public class AcademyNotFoundException extends RuntimeException {
    public AcademyNotFoundException(String message) {
        super(message);
    }
}
