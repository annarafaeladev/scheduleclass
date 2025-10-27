package br.com.api.scheduleclass.application.usecase.student;

import br.com.api.scheduleclass.application.dto.student.StudentCommand;

public interface CreateStudentUseCase {
    Long execute(Long academyId, StudentCommand command);
}
