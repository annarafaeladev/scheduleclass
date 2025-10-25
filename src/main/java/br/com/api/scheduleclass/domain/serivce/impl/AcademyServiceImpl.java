package br.com.api.scheduleclass.domain.serivce.impl;

import br.com.api.scheduleclass.domain.exception.AcademyNotFoundException;
import br.com.api.scheduleclass.domain.model.Academy;
import br.com.api.scheduleclass.domain.repository.AcademyRepository;
import br.com.api.scheduleclass.domain.serivce.AcademyService;

public class AcademyServiceImpl implements AcademyService {
    private final AcademyRepository academyRepository;

    public AcademyServiceImpl(AcademyRepository academyRepository) {
        this.academyRepository = academyRepository;
    }

    public Academy getAcademyById(Long id) {
        return academyRepository.findById(id)
                .orElseThrow(() -> new AcademyNotFoundException("Academia não encontrada para id: " + id));

    }
}
