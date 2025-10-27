package br.com.api.scheduleclass.domain.serivce.impl;

import br.com.api.scheduleclass.application.dto.student.StudentCommand;
import br.com.api.scheduleclass.application.exception.BusinessException;
import br.com.api.scheduleclass.domain.model.Student;
import br.com.api.scheduleclass.domain.serivce.StudentDomainService;

public class StudentServiceImpl implements StudentDomainService {
    @Override
    public void validateUniqueEmail(boolean exists) {
        if (exists) {
            throw new BusinessException("Já existe um aluno com este e-mail nesta academia.");
        }
    }

    @Override
    public Student update(Student student, StudentCommand command) {
        if (command.name() != null) student.setName(command.name());
        if (command.email() != null) student.setEmail(command.email());
        if (command.phone() != null) student.setPhone(command.phone());
        if (command.belt() != null) student.getBelt().setBeltLevel(command.belt());
        if (command.beltDegree() > 0 && command.beltDegree() <= 10) student.setBeltDegree(command.beltDegree());

        return student;
    }

    @Override
    public void disable(Student student) {
        if (!student.isActive()) {
            throw new BusinessException("Estudante já está desativado");
        }

        student.setActive(false);
    }

    @Override
    public void active(Student student) {
        if (student.isActive()) {
            throw new BusinessException("Estudante já está ativo");
        }

        student.setActive(true);
    }
}
