package br.com.api.scheduleclass.infrastructure.persistence.repository.impl;

import br.com.api.scheduleclass.application.repository.PlanRepository;
import br.com.api.scheduleclass.domain.model.Plan;
import br.com.api.scheduleclass.infrastructure.mapper.PlanMapper;
import br.com.api.scheduleclass.infrastructure.persistence.repository.PlanJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class PlanRepositoryImpl implements PlanRepository {

    private final PlanJpaRepository repository;

    @Override
    public Optional<Plan> findById(Long id) {
        return repository.findById(id)
                .map(PlanMapper::toDomain);
    }
}
