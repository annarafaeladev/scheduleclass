package br.com.api.scheduleclass.domain.serivce;

import br.com.api.scheduleclass.application.dto.academy.AcademyCommand;
import br.com.api.scheduleclass.domain.model.Academy;

public interface AcademyService {
    void validateUniqueEmail(boolean email);
    Academy update(Academy academy, AcademyCommand command);
    void disable(Academy academy);
    void active(Academy academy);
}
