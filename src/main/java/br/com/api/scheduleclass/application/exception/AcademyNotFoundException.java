package br.com.api.scheduleclass.application.exception;

public class AcademyNotFoundException extends RuntimeException {
    public AcademyNotFoundException(Long id) {
        super("Academy not found with id: " + id);
    }
}
