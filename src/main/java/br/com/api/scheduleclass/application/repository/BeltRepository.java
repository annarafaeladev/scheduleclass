package br.com.api.scheduleclass.application.repository;

import br.com.api.scheduleclass.domain.enums.BeltLevel;
import br.com.api.scheduleclass.domain.model.Belt;

import java.util.Optional;

public interface BeltRepository {

    Optional<Belt> findByBelt(BeltLevel level);
}
