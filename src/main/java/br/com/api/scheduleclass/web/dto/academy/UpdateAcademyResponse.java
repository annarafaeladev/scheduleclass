package br.com.api.scheduleclass.web.dto.academy;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record UpdateAcademyResponse(
        Long id,
        String name,
        String address,
        String phone,
        String email,
        LocalDateTime updatedAt
) {
}

