package br.com.api.scheduleclass.application.usecase.academy.impl;

import br.com.api.scheduleclass.application.usecase.academy.GetAcademyUseCase;
import br.com.api.scheduleclass.domain.model.Academy;
import br.com.api.scheduleclass.domain.serivce.AcademyService;

public class GetAcademyUseCaseImpl implements GetAcademyUseCase {

    private final AcademyService academyService;

    public GetAcademyUseCaseImpl(AcademyService academyService) {
        this.academyService = academyService;
    }

    @Override
    public Academy execute(Long id) {
        return academyService.getAcademyById(id);
    }

}