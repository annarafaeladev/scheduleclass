package br.com.api.scheduleclass.application.usecase.academy;

import br.com.api.scheduleclass.application.dto.academy.AcademyCommand;
import br.com.api.scheduleclass.domain.model.Academy;

public interface UpdateAcademyByIdUseCase {
    Academy execute(Long id, AcademyCommand comand);
}
