package br.com.api.scheduleclass.config.usecase;

import br.com.api.scheduleclass.application.usecase.academy.AcademyFindByIdUseCase;
import br.com.api.scheduleclass.application.usecase.academy.impl.AcademyFindByIdUseCaseImpl;
import br.com.api.scheduleclass.application.repository.AcademyRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AcademyUseCaseConfig {

    @Bean
    public AcademyFindByIdUseCase getAcademyUseCase(AcademyRepository repository) {
        return new AcademyFindByIdUseCaseImpl(repository);
    }
}
