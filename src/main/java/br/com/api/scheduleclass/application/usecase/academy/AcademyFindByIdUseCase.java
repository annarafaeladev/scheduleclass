package br.com.api.scheduleclass.application.usecase.academy;

import br.com.api.scheduleclass.domain.model.Academy;

public interface AcademyFindByIdUseCase {
    Academy execute(Long id);
}
