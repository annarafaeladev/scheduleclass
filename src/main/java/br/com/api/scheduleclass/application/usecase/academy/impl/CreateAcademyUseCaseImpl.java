package br.com.api.scheduleclass.application.usecase.academy.impl;

import br.com.api.scheduleclass.application.dto.academy.AcademyCommand;
import br.com.api.scheduleclass.application.repository.AcademyRepository;
import br.com.api.scheduleclass.application.usecase.academy.CreateAcademyUseCase;
import br.com.api.scheduleclass.domain.model.Academy;
import br.com.api.scheduleclass.domain.serivce.AcademyDomainService;

public class CreateAcademyUseCaseImpl implements CreateAcademyUseCase {

    private final AcademyRepository repository;
    private final AcademyDomainService academyService;

    public CreateAcademyUseCaseImpl(AcademyRepository repository, AcademyDomainService academyService) {
        this.repository = repository;
        this.academyService = academyService;
    }

    @Override
    public Long execute(AcademyCommand command) {
        boolean emailAlreadyExists = repository.existsByEmail(command.email());
        academyService.validateUniqueEmail(emailAlreadyExists);

        Academy academy = toAcademy(command);

        return repository.save(academy).getId();
    }

    private static Academy toAcademy(AcademyCommand command) {
        return new Academy(
                command.name(),
                command.address(),
                command.phone(),
                command.email(),
                true
        );
    }
}