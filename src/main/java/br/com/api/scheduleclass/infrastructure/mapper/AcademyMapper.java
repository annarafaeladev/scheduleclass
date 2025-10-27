package br.com.api.scheduleclass.infrastructure.mapper;

import br.com.api.scheduleclass.domain.model.Academy;
import br.com.api.scheduleclass.infrastructure.persistence.jpa.AcademyEntity;

public class AcademyMapper {

    private AcademyMapper(){}

    public static Academy toDomain(AcademyEntity entity) {
        return new Academy(
                entity.getId(),
                entity.getName(),
                entity.getAddress(),
                entity.getPhone(),
                entity.getEmail(),
                entity.getActive(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }

    public static AcademyEntity toEntity(Academy academy) {
        AcademyEntity entity = new AcademyEntity();
        entity.setId(academy.getId());
        entity.setName(academy.getName());
        entity.setAddress(academy.getAddress());
        entity.setEmail(academy.getEmail());
        entity.setPhone(academy.getPhone());
        entity.setActive(academy.getActive());

        return entity;
    }
}
