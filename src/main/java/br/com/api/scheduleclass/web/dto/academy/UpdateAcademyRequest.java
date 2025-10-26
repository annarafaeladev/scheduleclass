package br.com.api.scheduleclass.web.dto.academy;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record UpdateAcademyRequest(
        @Size(max = 100, message = "O nome deve ter no máximo 100 caracteres")
        String name,

        @Size(max = 300, message = "O endereço deve ter no máximo 300 caracteres")
        String address,

        @Pattern(regexp = "\\+?\\d{10,15}", message = "O telefone deve ser válido, com 10 a 15 dígitos")
        String phone,

        @Email(message = "O email deve ser válido")
        String email
) {}

