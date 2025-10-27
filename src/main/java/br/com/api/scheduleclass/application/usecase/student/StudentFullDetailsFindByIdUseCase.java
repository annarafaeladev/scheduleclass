package br.com.api.scheduleclass.application.usecase.student;

import br.com.api.scheduleclass.domain.model.Student;

public interface StudentFullDetailsFindByIdUseCase {
    Student execute(Long id);
}
