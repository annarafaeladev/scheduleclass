package br.com.api.scheduleclass.application.usecase.student.impl;

import br.com.api.scheduleclass.application.common.FinderUtils;
import br.com.api.scheduleclass.application.dto.student.StudentCommand;
import br.com.api.scheduleclass.application.exception.AcademyNotFoundException;
import br.com.api.scheduleclass.application.repository.AcademyRepository;
import br.com.api.scheduleclass.application.repository.BeltRepository;
import br.com.api.scheduleclass.application.repository.PlanRepository;
import br.com.api.scheduleclass.application.repository.StudentRepository;
import br.com.api.scheduleclass.application.usecase.student.CreateStudentUseCase;
import br.com.api.scheduleclass.domain.model.Academy;
import br.com.api.scheduleclass.domain.model.Belt;
import br.com.api.scheduleclass.domain.model.Plan;
import br.com.api.scheduleclass.domain.model.Student;
import br.com.api.scheduleclass.domain.serivce.StudentDomainService;

import java.math.BigDecimal;

public class CreateStudentUseCaseImpl implements CreateStudentUseCase {

    private final StudentRepository studentRepository;
    private final AcademyRepository academyRepository;
    private final BeltRepository beltRepository;
    private final PlanRepository planRepository;
    private final StudentDomainService studentDomainService;

    public CreateStudentUseCaseImpl(
            StudentRepository studentRepository,
            AcademyRepository academyRepository,
            BeltRepository beltRepository, PlanRepository planRepository,
            StudentDomainService studentDomainService
    ) {
        this.studentRepository = studentRepository;
        this.academyRepository = academyRepository;
        this.beltRepository = beltRepository;
        this.planRepository = planRepository;
        this.studentDomainService = studentDomainService;
    }

    @Override
    public Long execute(Long academyId, StudentCommand command) {
        Academy academy = FinderUtils.findOrThrow(
                academyRepository::findById,
                AcademyNotFoundException::new,
                academyId
        );

        studentDomainService.validateUniqueEmail(
                studentRepository.existsByEmailByAcademyId(command.email(), academyId));

        Belt belt = beltRepository.findByBelt(command.belt()).orElse(null);
        Plan plan = planRepository.findById(1L).get();

        Student student = toStudent(command, academy, belt, plan);
        return studentRepository.save(student).getId();
    }

    private Student toStudent(StudentCommand command, Academy academy, Belt belt, Plan plan) {
        Student student = new Student();
        student.setName(command.name());
        student.setEmail(command.email());
        student.setPhone(command.phone());
        student.setBelt(belt);
        student.setAcademy(academy);
        student.setBeltDegree(command.beltDegree());
        student.setPlan(plan);
        return student;
    }
}