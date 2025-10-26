package br.com.api.scheduleclass.web.dto.errors;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponseDTO {

    private LocalDateTime timestamp;
    private int status;
    private String error;
    private List<String> errors;
    private String message;
    private String path;
}

