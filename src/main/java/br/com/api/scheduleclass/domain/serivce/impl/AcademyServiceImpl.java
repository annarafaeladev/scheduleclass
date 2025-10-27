package br.com.api.scheduleclass.domain.serivce.impl;

import br.com.api.scheduleclass.application.dto.academy.AcademyCommand;
import br.com.api.scheduleclass.application.exception.BusinessException;
import br.com.api.scheduleclass.domain.model.Academy;
import br.com.api.scheduleclass.domain.serivce.AcademyDomainService;

public class AcademyServiceImpl implements AcademyDomainService {

    @Override
    public void validateUniqueEmail(boolean emailAlreadyExists) {
        if (emailAlreadyExists) {
            throw new BusinessException("E-mail já cadastrado");
        }
    }

    @Override
    public Academy update(Academy academy, AcademyCommand command) {
        if (command.name() != null) academy.setName(command.name());
        if (command.address() != null) academy.setAddress(command.address());
        if (command.phone() != null) academy.setPhone(command.phone());
        if (command.email() != null) academy.setEmail(command.email());

        return academy;
    }

    @Override
    public void disable(Academy academy) {
        if (!academy.getActive()) {
            throw new BusinessException("Academia já está desativada");
        }

        academy.setActive(false);
    }

    @Override
    public void active(Academy academy) {
        if (academy.getActive()) {
            throw new BusinessException("Academia já está ativa");
        }

        academy.setActive(true);
    }
}
