package br.com.api.scheduleclass.web.controller;

import br.com.api.scheduleclass.application.dto.ErrorResponseDTO;
import br.com.api.scheduleclass.application.exception.AcademyNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AcademyNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleAcademyNotFound(
            AcademyNotFoundException ex,
            HttpServletRequest request
    ) {
        ErrorResponseDTO error = new ErrorResponseDTO(
                HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND.getReasonPhrase(),
                ex.getMessage(),
                request.getRequestURI()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    // Aqui você pode adicionar outros handlers para outras exceções
    // @ExceptionHandler(StudentNotFoundException.class)
    // public ResponseEntity<String> handleStudentNotFound(StudentNotFoundException ex) { ... }
}
