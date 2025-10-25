package br.com.api.scheduleclass.domain.repository;

import br.com.api.scheduleclass.domain.model.Academy;

import java.util.Optional;

public interface AcademyRepository {

    Optional<Academy> findById(Long id);
}
