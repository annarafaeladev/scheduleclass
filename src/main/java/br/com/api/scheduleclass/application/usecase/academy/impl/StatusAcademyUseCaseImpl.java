package br.com.api.scheduleclass.application.usecase.academy.impl;

import br.com.api.scheduleclass.application.common.FinderUtils;
import br.com.api.scheduleclass.application.exception.AcademyNotFoundException;
import br.com.api.scheduleclass.application.repository.AcademyRepository;
import br.com.api.scheduleclass.application.usecase.academy.StatusAcademyByIdUseCase;
import br.com.api.scheduleclass.domain.model.Academy;
import br.com.api.scheduleclass.domain.serivce.AcademyDomainService;

public class StatusAcademyUseCaseImpl implements StatusAcademyByIdUseCase {

    private final AcademyRepository repository;
    private final AcademyDomainService academyService;

    public StatusAcademyUseCaseImpl(AcademyRepository repository, AcademyDomainService academyService) {
        this.repository = repository;
        this.academyService = academyService;
    }

    @Override
    public Academy execute(Long id) {
        Academy academy = FinderUtils.findOrThrow(repository::findById, AcademyNotFoundException::new, id);

        if (academy.getActive())
            academyService.disable(academy);
        else
            academyService.active(academy);

        return repository.save(academy);
    }
}