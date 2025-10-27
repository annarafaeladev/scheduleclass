package br.com.api.scheduleclass.application.dto.student;

import br.com.api.scheduleclass.domain.enums.BeltLevel;

public record StudentCommand(
        String name,
        String email,
        String phone,
        BeltLevel belt,
        int beltDegree
) {

}
