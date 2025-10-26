package br.com.api.scheduleclass.application.usecase.academy.impl;

import br.com.api.scheduleclass.application.common.FinderUtils;
import br.com.api.scheduleclass.application.dto.academy.AcademyCommand;
import br.com.api.scheduleclass.application.exception.AcademyNotFoundException;
import br.com.api.scheduleclass.application.repository.AcademyRepository;
import br.com.api.scheduleclass.application.usecase.academy.UpdateAcademyByIdUseCase;
import br.com.api.scheduleclass.domain.model.Academy;
import br.com.api.scheduleclass.domain.serivce.AcademyService;

public class UpdateAcademyUseCaseImpl implements UpdateAcademyByIdUseCase {

    private final AcademyRepository repository;
    private final AcademyService academyService;

    public UpdateAcademyUseCaseImpl(AcademyRepository repository, AcademyService academyService) {
        this.repository = repository;
        this.academyService = academyService;
    }

    @Override
    public Academy execute(Long id, AcademyCommand command) {
        Academy academy = FinderUtils.findOrThrow(repository::findById, AcademyNotFoundException::new, id);

        if (command.email() != null && !academy.getEmail().equals(command.email())) {
            academyService.validateUniqueEmail(repository.existsByEmail(command.email()));
        }

        academyService.update(academy, command);

        return repository.save(academy);
    }
}