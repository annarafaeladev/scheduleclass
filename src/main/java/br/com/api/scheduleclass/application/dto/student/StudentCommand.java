package br.com.api.scheduleclass.application.dto.student;

public record StudentCommand(
        String name,
        String email,
        String phone,
        boolean active,
        int beltDegree,
        int totalBookings
) {

}
