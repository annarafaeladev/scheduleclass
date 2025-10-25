package br.com.api.scheduleclass.infrastructure.persistence.repository;

import br.com.api.scheduleclass.infrastructure.persistence.jpa.AcademyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcademyJpaRepository extends JpaRepository<AcademyEntity, Long> {
}
