package br.com.api.scheduleclass.domain.serivce.impl;

import br.com.api.scheduleclass.application.exception.BusinessException;
import br.com.api.scheduleclass.domain.serivce.AcademyService;

public class AcademyServiceImpl implements AcademyService {

    @Override
    public void validateUniqueEmail(boolean emailAlreadyExists) {
        if (emailAlreadyExists) {
            throw new BusinessException("E-mail já cadastrado");
        }
    }
}
