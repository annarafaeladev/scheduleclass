package br.com.api.scheduleclass.config.usecase;

import br.com.api.scheduleclass.application.repository.AcademyRepository;
import br.com.api.scheduleclass.application.repository.BeltRepository;
import br.com.api.scheduleclass.application.repository.PlanRepository;
import br.com.api.scheduleclass.application.repository.StudentRepository;
import br.com.api.scheduleclass.application.usecase.student.CreateStudentUseCase;
import br.com.api.scheduleclass.application.usecase.student.StudentFullDetailsFindByIdUseCase;
import br.com.api.scheduleclass.application.usecase.student.StudentResumeFindByIdUseCase;
import br.com.api.scheduleclass.application.usecase.student.impl.CreateStudentUseCaseImpl;
import br.com.api.scheduleclass.application.usecase.student.impl.StudentFullDetailsFindByIdUseCaseImpl;
import br.com.api.scheduleclass.application.usecase.student.impl.StudentResumeFindByIdUseCaseImpl;
import br.com.api.scheduleclass.domain.serivce.StudentDomainService;
import br.com.api.scheduleclass.domain.serivce.impl.StudentServiceImpl;
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

    @Bean
    public CreateStudentUseCase createStudentUseCase(
            StudentRepository studentRepository,
            AcademyRepository academyRepository,
            BeltRepository beltRepository,
            PlanRepository planRepository,
            StudentDomainService studentDomainService
    ) {
        return new CreateStudentUseCaseImpl(studentRepository, academyRepository, beltRepository, planRepository, studentDomainService);
    }

    @Bean
    public StudentDomainService studentDomainService() {
        return new StudentServiceImpl();
    }
}
