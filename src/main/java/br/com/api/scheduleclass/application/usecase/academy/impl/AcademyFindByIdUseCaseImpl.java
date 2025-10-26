package br.com.api.scheduleclass.application.usecase.academy.impl;

import br.com.api.scheduleclass.application.common.FinderUtils;
import br.com.api.scheduleclass.application.usecase.academy.AcademyFindByIdUseCase;
import br.com.api.scheduleclass.application.exception.AcademyNotFoundException;
import br.com.api.scheduleclass.domain.model.Academy;
import br.com.api.scheduleclass.application.repository.AcademyRepository;

public class AcademyFindByIdUseCaseImpl implements AcademyFindByIdUseCase {

    private final AcademyRepository repository;

    public AcademyFindByIdUseCaseImpl(AcademyRepository repository) {
        this.repository = repository;
    }

    @Override
    public Academy execute(Long id) {
        return FinderUtils.findOrThrow(repository::findById, AcademyNotFoundException::new, id);
    }


}