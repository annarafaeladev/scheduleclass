package br.com.api.scheduleclass.application.usecase.academy;

import br.com.api.scheduleclass.application.dto.academy.AcademyCommand;

public interface CreateAcademyUseCase {
    Long execute(AcademyCommand comand);
}
