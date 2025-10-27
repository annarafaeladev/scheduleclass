package br.com.api.scheduleclass.application.usecase.student.impl;

import br.com.api.scheduleclass.application.common.FinderUtils;
import br.com.api.scheduleclass.application.exception.StudentNotFoundException;
import br.com.api.scheduleclass.application.repository.StudentRepository;
import br.com.api.scheduleclass.application.usecase.student.StudentFullDetailsFindByIdUseCase;
import br.com.api.scheduleclass.domain.model.Student;

public class StudentFullDetailsFindByIdUseCaseImpl implements StudentFullDetailsFindByIdUseCase {

    private final StudentRepository repository;

    public StudentFullDetailsFindByIdUseCaseImpl(StudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public Student execute(Long id) {
        return FinderUtils.findOrThrow(repository::findById, StudentNotFoundException::new, id);
    }


}