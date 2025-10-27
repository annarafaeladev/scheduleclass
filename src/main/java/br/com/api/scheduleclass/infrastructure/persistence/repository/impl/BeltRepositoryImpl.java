package br.com.api.scheduleclass.infrastructure.persistence.repository.impl;

import br.com.api.scheduleclass.application.repository.BeltRepository;
import br.com.api.scheduleclass.domain.enums.BeltLevel;
import br.com.api.scheduleclass.domain.model.Belt;
import br.com.api.scheduleclass.infrastructure.mapper.BeltMapper;
import br.com.api.scheduleclass.infrastructure.persistence.repository.BeltJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class BeltRepositoryImpl implements BeltRepository {

    private final BeltJpaRepository repository;

    @Override
    public Optional<Belt> findByBelt(BeltLevel belt) {
        return repository.findByBeltLevel(belt.name())
                .map(BeltMapper::toDomain);
    }
}
