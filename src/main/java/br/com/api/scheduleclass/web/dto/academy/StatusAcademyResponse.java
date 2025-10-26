package br.com.api.scheduleclass.web.dto.academy;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;

public record StatusAcademyResponse(
        Long id,
        Boolean active,
        LocalDateTime updatedAt
) {
}

