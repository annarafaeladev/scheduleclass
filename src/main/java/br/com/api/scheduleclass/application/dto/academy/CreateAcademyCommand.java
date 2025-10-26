package br.com.api.scheduleclass.application.dto.academy;

public record CreateAcademyCommand(String name,
                                   String address,
                                   String phone,
                                   String email) {
}
