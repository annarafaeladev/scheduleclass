package br.com.api.scheduleclass.application.dto.student;

public record StudentResume(
        Long id,
        String name,
        String email,
        String phone,
        boolean active,
        int beltDegree,
        int totalBookings
) {

}
