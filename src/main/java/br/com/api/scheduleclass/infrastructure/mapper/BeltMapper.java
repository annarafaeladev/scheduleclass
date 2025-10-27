package br.com.api.scheduleclass.infrastructure.mapper;

import br.com.api.scheduleclass.domain.model.Academy;
import br.com.api.scheduleclass.domain.model.Belt;
import br.com.api.scheduleclass.infrastructure.persistence.jpa.AcademyEntity;
import br.com.api.scheduleclass.infrastructure.persistence.jpa.BeltEntity;

public class BeltMapper {

    private BeltMapper(){}

    public static Belt toDomain(BeltEntity entity) {
        return new Belt(
                entity.getId(),
                entity.getName(),
                entity.getBeltLevel(),
                entity.getLessonsTonext(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }

    public static BeltEntity toEntity(Belt belt) {
        BeltEntity entity = new BeltEntity();
        entity.setId(belt.getId());
        entity.setName(belt.getName());
        entity.setBeltLevel(belt.getBeltLevel());
        entity.setLessonsTonext(belt.getLessonsTonext());

        return entity;
    }
}
