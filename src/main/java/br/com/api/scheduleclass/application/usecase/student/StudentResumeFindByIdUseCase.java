package br.com.api.scheduleclass.application.usecase.student;

import br.com.api.scheduleclass.application.dto.student.StudentResume;

public interface StudentResumeFindByIdUseCase {
    StudentResume execute(Long id);
}
