package br.com.api.scheduleclass.infrastructure.persistence.repository;

import br.com.api.scheduleclass.infrastructure.persistence.jpa.AcademyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AcademyJpaRepository extends JpaRepository<AcademyEntity, Long> {

    Optional<AcademyEntity> findByEmail(String email);
    boolean existsByEmail(String email);

}
