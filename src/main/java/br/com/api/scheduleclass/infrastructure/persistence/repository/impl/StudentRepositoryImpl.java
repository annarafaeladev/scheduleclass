package br.com.api.scheduleclass.infrastructure.persistence.repository.impl;

import br.com.api.scheduleclass.application.repository.StudentRepository;
import br.com.api.scheduleclass.domain.model.Student;
import br.com.api.scheduleclass.infrastructure.mapper.StudentMapper;
import br.com.api.scheduleclass.infrastructure.persistence.jpa.StudentEntity;
import br.com.api.scheduleclass.infrastructure.persistence.repository.StudentJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class StudentRepositoryImpl implements StudentRepository {

    private final StudentJpaRepository repository;

    @Override
    public Optional<Student> findById(Long id) {
        return repository.findById(id)
                .map(StudentMapper::toDomain);
    }

    @Override
    public Student save(Student student) {
        StudentEntity studentEntity = repository.save(StudentMapper.toEntity(student));

        return StudentMapper.toDomain(studentEntity);
    }

    @Override
    public Optional<Student> findByEmail(String email) {
        return repository.findByEmail(email)
                .map(StudentMapper::toDomain);
    }

    @Override
    public boolean existsByEmailByAcademyId(String email, Long academyId) {
        return repository.existsByEmailAndAcademyId(email, academyId);
    }

}
