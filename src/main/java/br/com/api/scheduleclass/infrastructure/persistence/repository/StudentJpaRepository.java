package br.com.api.scheduleclass.infrastructure.persistence.repository;

import br.com.api.scheduleclass.infrastructure.persistence.jpa.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentJpaRepository extends JpaRepository<StudentEntity, Long> {

    Optional<StudentEntity> findByEmail(String email);
    boolean existsByEmailAndAcademyId(String email, Long academyId);

}
