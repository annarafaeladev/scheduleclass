package br.com.api.scheduleclass.config.usecase;


import br.com.api.scheduleclass.application.usecase.academy.GetAcademyUseCase;
import br.com.api.scheduleclass.application.usecase.academy.impl.GetAcademyUseCaseImpl;
import br.com.api.scheduleclass.domain.repository.AcademyRepository;
import br.com.api.scheduleclass.domain.serivce.AcademyService;
import br.com.api.scheduleclass.domain.serivce.impl.AcademyServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AcademyUseCaseConfig {

    @Bean
    public AcademyService academyService(AcademyRepository academyRepository) {
        return new AcademyServiceImpl(academyRepository);
    }

    @Bean
    public GetAcademyUseCase getAcademyUseCase(AcademyService academyService) {
        return new GetAcademyUseCaseImpl(academyService);
    }
}
