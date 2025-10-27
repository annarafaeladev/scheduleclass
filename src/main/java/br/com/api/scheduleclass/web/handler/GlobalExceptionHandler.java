package br.com.api.scheduleclass.web.handler;

import br.com.api.scheduleclass.application.exception.StudentNotFoundException;
import br.com.api.scheduleclass.web.dto.errors.ErrorResponseDTO;
import br.com.api.scheduleclass.application.exception.AcademyNotFoundException;
import br.com.api.scheduleclass.application.exception.BusinessException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AcademyNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleAcademyNotFound(
            AcademyNotFoundException ex,
            HttpServletRequest request
    ) {
        ErrorResponseDTO error = new ErrorResponseDTO();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setError(ex.getMessage());
        error.setMessage(HttpStatus.NOT_FOUND.getReasonPhrase());
        error.setPath(request.getRequestURI());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleStudentNotFoundException(
            StudentNotFoundException ex,
            HttpServletRequest request
    ) {
        ErrorResponseDTO error = new ErrorResponseDTO();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setError(ex.getMessage());
        error.setMessage(HttpStatus.NOT_FOUND.getReasonPhrase());
        error.setPath(request.getRequestURI());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponseDTO> handleValidationErrors(
            MethodArgumentNotValidException ex,
            HttpServletRequest request) {

        List<String> errorMessages = ex.getBindingResult().getFieldErrors().stream()
                .map(err -> err.getField() + ": " + err.getDefaultMessage())
                .toList();

        ErrorResponseDTO errorResponse = new ErrorResponseDTO();

        errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        errorResponse.setErrors(errorMessages);
        errorResponse.setMessage(HttpStatus.BAD_REQUEST.getReasonPhrase());
        errorResponse.setPath(request.getRequestURI());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorResponseDTO> handleConstraintViolation(
            ConstraintViolationException ex,
            HttpServletRequest request) {

        List<String> errorMessages = ex.getConstraintViolations().stream()
                .map(v -> v.getPropertyPath() + ": " + v.getMessage())
                .toList();


        ErrorResponseDTO errorResponse = new ErrorResponseDTO();

        errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        errorResponse.setErrors(errorMessages);
        errorResponse.setMessage(HttpStatus.BAD_REQUEST.getReasonPhrase());
        errorResponse.setPath(request.getRequestURI());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorResponseDTO> handleBusinessException(
            BusinessException ex,
            HttpServletRequest request) {


        ErrorResponseDTO errorResponse = new ErrorResponseDTO();

        errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        errorResponse.setError(ex.getMessage());
        errorResponse.setMessage(HttpStatus.BAD_REQUEST.getReasonPhrase());
        errorResponse.setPath(request.getRequestURI());

        return ResponseEntity.badRequest().body(errorResponse);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDTO> handleGenericException(
            Exception ex,
            HttpServletRequest request) {


        ErrorResponseDTO errorResponse = new ErrorResponseDTO();

        errorResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        errorResponse.setError("Error interno servidor");
        errorResponse.setMessage(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
        errorResponse.setPath(request.getRequestURI());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }
}


