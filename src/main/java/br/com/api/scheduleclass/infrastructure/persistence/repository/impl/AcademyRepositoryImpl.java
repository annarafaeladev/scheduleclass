package br.com.api.scheduleclass.infrastructure.persistence.repository.impl;

import br.com.api.scheduleclass.domain.model.Academy;
import br.com.api.scheduleclass.application.repository.AcademyRepository;
import br.com.api.scheduleclass.infrastructure.mapper.AcademyMapper;
import br.com.api.scheduleclass.infrastructure.persistence.jpa.AcademyEntity;
import br.com.api.scheduleclass.infrastructure.persistence.repository.AcademyJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class AcademyRepositoryImpl implements AcademyRepository {

    private final AcademyJpaRepository academyJpaRepository;

    @Override
    public Optional<Academy> findById(Long id) {

        return academyJpaRepository.findById(id)
                .map(AcademyMapper::toDomain);
    }

    @Override
    public Academy save(Academy academy) {
        AcademyEntity entity = AcademyMapper.toEntity(academy);

        AcademyEntity academyEntity = academyJpaRepository.save(entity);

        return AcademyMapper.toDomain(academyEntity);
    }

    @Override
    public Optional<Academy> findByEmail(String email) {
        return academyJpaRepository.findByEmail(email)
                .map(AcademyMapper::toDomain);
    }

    @Override
    public boolean existsByEmail(String email) {
        return academyJpaRepository.existsByEmail(email);
    }

}
