package br.com.api.scheduleclass.config.usecase;

import br.com.api.scheduleclass.application.usecase.academy.*;
import br.com.api.scheduleclass.application.usecase.academy.impl.*;
import br.com.api.scheduleclass.application.repository.AcademyRepository;
import br.com.api.scheduleclass.domain.serivce.AcademyService;
import br.com.api.scheduleclass.domain.serivce.impl.AcademyServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AcademyUseCaseConfig {

    @Bean
    public AcademyFindByIdUseCase academyFindByIdUseCase(AcademyRepository repository) {
        return new AcademyFindByIdUseCaseImpl(repository);
    }

    @Bean
    public CreateAcademyUseCase createAcademyUseCase(AcademyRepository repository, AcademyService academyService) {
        return new CreateAcademyUseCaseImpl(repository, academyService);
    }

    @Bean
    public UpdateAcademyByIdUseCase updateAcademyByIdUseCase(AcademyRepository repository, AcademyService academyService) {
        return new UpdateAcademyUseCaseImpl(repository, academyService);
    }

    @Bean
    public StatusAcademyByIdUseCase deleteAcademyByIdUseCase(AcademyRepository repository, AcademyService academyService) {
        return new StatusAcademyUseCaseImpl(repository, academyService);
    }

    @Bean
    public AcademyService academyService() {
        return new AcademyServiceImpl();
    }
}
