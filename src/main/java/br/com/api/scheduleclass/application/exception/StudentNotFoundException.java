package br.com.api.scheduleclass.application.exception;

public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException(Long id) {
        super("Student not found: " + id);
    }

    public StudentNotFoundException() {
        super("Student not found");
    }


}
