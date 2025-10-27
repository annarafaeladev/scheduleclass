package br.com.api.scheduleclass.config.usecase;

import br.com.api.scheduleclass.application.repository.StudentRepository;
import br.com.api.scheduleclass.application.usecase.student.StudentFullDetailsFindByIdUseCase;
import br.com.api.scheduleclass.application.usecase.student.StudentResumeFindByIdUseCase;
import br.com.api.scheduleclass.application.usecase.student.impl.StudentFullDetailsFindByIdUseCaseImpl;
import br.com.api.scheduleclass.application.usecase.student.impl.StudentResumeFindByIdUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentUseCaseConfig {

    @Bean
    public StudentFullDetailsFindByIdUseCase studentFullDetailsFindByIdUseCase(StudentRepository repository) {
        return new StudentFullDetailsFindByIdUseCaseImpl(repository);
    }

    @Bean
    public StudentResumeFindByIdUseCase studentResumeFindByIdUseCase(StudentRepository repository) {
        return new StudentResumeFindByIdUseCaseImpl(repository);
    }

}
