package br.com.api.scheduleclass.application.repository;


import br.com.api.scheduleclass.domain.model.Plan;

import java.util.Optional;

public interface PlanRepository {

    Optional<Plan> findById(Long id);
}
