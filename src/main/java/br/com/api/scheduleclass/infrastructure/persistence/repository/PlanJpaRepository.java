package br.com.api.scheduleclass.infrastructure.persistence.repository;

import br.com.api.scheduleclass.infrastructure.persistence.jpa.PlanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlanJpaRepository extends JpaRepository<PlanEntity, Long> {

    Optional<PlanEntity> findById(Long id);

}
