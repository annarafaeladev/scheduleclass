package br.com.api.scheduleclass.web.dto.academy;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record CreateAcademyRequest(
        @NotBlank(message = "O nome é obrigatório")
        @Size(max = 100, message = "O nome deve ter no máximo 100 caracteres")
        String name,

        @NotBlank(message = "O endereço é obrigatório")
        @Size(max = 200, message = "O endereço deve ter no máximo 200 caracteres")
        String address,

        @NotBlank(message = "O telefone é obrigatório")
        @Pattern(regexp = "\\+?\\d{10,15}", message = "O telefone deve ser válido, com 10 a 15 dígitos")
        String phone,

        @NotBlank(message = "O email é obrigatório")
        @Email(message = "O email deve ser válido")
        String email
) {}

