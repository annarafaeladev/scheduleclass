package br.com.api.scheduleclass.domain.serivce;

import br.com.api.scheduleclass.application.dto.student.StudentCommand;
import br.com.api.scheduleclass.domain.model.Student;

public interface StudentDomainService {
    void validateUniqueEmail(boolean email);
    Student update(Student student, StudentCommand command);
    void disable(Student student);
    void active(Student student);
}
