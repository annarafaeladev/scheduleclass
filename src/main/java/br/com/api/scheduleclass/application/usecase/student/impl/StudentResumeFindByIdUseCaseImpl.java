package br.com.api.scheduleclass.application.usecase.student.impl;

import br.com.api.scheduleclass.application.common.FinderUtils;
import br.com.api.scheduleclass.application.dto.student.StudentResume;
import br.com.api.scheduleclass.application.exception.StudentNotFoundException;
import br.com.api.scheduleclass.application.repository.StudentRepository;
import br.com.api.scheduleclass.application.usecase.student.StudentResumeFindByIdUseCase;
import br.com.api.scheduleclass.domain.model.Student;

public class StudentResumeFindByIdUseCaseImpl implements StudentResumeFindByIdUseCase {

    private final StudentRepository repository;

    public StudentResumeFindByIdUseCaseImpl(StudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public StudentResume execute(Long id) {
        Student student = FinderUtils.findOrThrow(repository::findById, StudentNotFoundException::new, id);
        return toResume(student);
    }

    private StudentResume toResume(Student student) {
        return new StudentResume(
                student.getId(),
                student.getName(),
                student.getEmail(),
                student.getPhone(),
                student.isActive(),
                student.getBeltDegree(),
                student.getTotalBookings()
        );
    }


}