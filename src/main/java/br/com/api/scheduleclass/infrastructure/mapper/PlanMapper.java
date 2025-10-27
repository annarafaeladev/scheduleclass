package br.com.api.scheduleclass.infrastructure.mapper;

import br.com.api.scheduleclass.domain.model.Plan;
import br.com.api.scheduleclass.infrastructure.persistence.jpa.PlanEntity;

public class PlanMapper {

    private PlanMapper(){}

    public static Plan toDomain(PlanEntity entity) {
        return new Plan(
                entity.getId(),
                entity.getName(),
                entity.getMonthlyLimit(),
                entity.getPrice(),
                entity.getDescription(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }

    public static PlanEntity toEntity(Plan plan) {
        PlanEntity entity = new PlanEntity();
        entity.setId(plan.getId());
        entity.setName(plan.getName());
        entity.setDescription(plan.getDescription());
        entity.setPrice(plan.getPrice());
        entity.setMonthlyLimit(plan.getMonthlyLimit());

        return entity;
    }
}
