package br.com.api.scheduleclass.application.repository;

import br.com.api.scheduleclass.domain.model.Academy;

import java.util.Optional;

public interface AcademyRepository {

    Optional<Academy> findById(Long id);
    Academy save(Academy academy);
    Optional<Academy> findByEmail(String email);
    boolean existsByEmail(String email);
}
