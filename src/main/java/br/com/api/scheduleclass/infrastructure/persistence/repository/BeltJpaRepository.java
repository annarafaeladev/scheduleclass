package br.com.api.scheduleclass.infrastructure.persistence.repository;

import br.com.api.scheduleclass.domain.enums.BeltLevel;
import br.com.api.scheduleclass.infrastructure.persistence.jpa.BeltEntity;
import br.com.api.scheduleclass.infrastructure.persistence.jpa.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BeltJpaRepository extends JpaRepository<BeltEntity, Long> {


    @Query(value = "SELECT * FROM belt WHERE belt_level = CAST(:beltLevel AS belt_level)", nativeQuery = true)
    Optional<BeltEntity> findByBeltLevel(@Param("beltLevel") String beltLevel);

}
