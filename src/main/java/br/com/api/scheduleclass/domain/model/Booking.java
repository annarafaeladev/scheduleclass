package br.com.api.scheduleclass.domain.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Booking {
    private Long id;
    private Long classId;
    private Long studentId;
    private LocalDate bookingDate;
    private LocalDateTime createAt;
    private boolean canceled;

    public Booking() {
    }


}
