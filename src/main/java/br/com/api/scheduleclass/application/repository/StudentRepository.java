package br.com.api.scheduleclass.application.repository;

import br.com.api.scheduleclass.domain.model.Student;

import java.util.Optional;

public interface StudentRepository {

    Optional<Student> findById(Long id);
    Student save(Student student);
    Optional<Student> findByEmail(String email);
    boolean existsByEmail(String email);
}
