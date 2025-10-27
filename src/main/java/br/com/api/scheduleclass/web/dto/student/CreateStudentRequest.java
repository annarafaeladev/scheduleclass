package br.com.api.scheduleclass.web.dto.student;

import br.com.api.scheduleclass.domain.enums.BeltLevel;
import jakarta.validation.constraints.*;

public record CreateStudentRequest(
        @NotBlank(message = "O nome é obrigatório")
        @Size(max = 100, message = "O nome deve ter no máximo 100 caracteres")
        String name,

        @NotBlank(message = "O telefone é obrigatório")
        @Pattern(regexp = "\\+?\\d{10,15}", message = "O telefone deve ser válido, com 10 a 15 dígitos")
        String phone,

        @NotBlank(message = "O email é obrigatório")
        @Email(message = "O email deve ser válido")
        String email,

        @NotNull(message = "O campo belt é obrigatório")
        BeltLevel belt,

        @Min(value = 0, message = "O Grau minimo é zero")
        @Max(value = 4, message = "O Grau maximo é zero")
        int beltDegree

) {}

