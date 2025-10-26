package br.com.api.scheduleclass.application.usecase.academy;

import br.com.api.scheduleclass.application.dto.academy.CreateAcademyCommand;

public interface CreateAcademyUseCase {
    Long execute(CreateAcademyCommand comand);
}
