package br.com.api.scheduleclass.infrastructure.persistence.repository.impl;

import br.com.api.scheduleclass.domain.model.Academy;
import br.com.api.scheduleclass.domain.repository.AcademyRepository;
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
                .map(this::toDomain);
    }

    private Academy toDomain(AcademyEntity entity) {
        return new Academy(
                entity.getId(),
                entity.getName(),
                entity.getAddress(),
                entity.getPhone(),
                entity.getEmail(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }

    private AcademyEntity toEntity(Academy academy) {
        AcademyEntity entity = new AcademyEntity();
        entity.setId(academy.getId());
        entity.setName(academy.getName());
        entity.setAddress(academy.getAddress());
        return entity;
    }
}
