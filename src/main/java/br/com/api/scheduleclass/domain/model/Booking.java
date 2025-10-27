package br.com.api.scheduleclass.domain.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Booking extends Base{
    private Long id;
    private Long classId;
    private Long studentId;
    private LocalDate bookingDate;
    private boolean canceled;

    public Booking() {
        super(LocalDateTime.now(), LocalDateTime.now());
    }

    public Booking(LocalDateTime createdAt, LocalDateTime updatedAt, Long id, Long classId, Long studentId, LocalDate bookingDate, boolean canceled) {
        super(createdAt, updatedAt);
        this.id = id;
        this.classId = classId;
        this.studentId = studentId;
        this.bookingDate = bookingDate;
        this.canceled = canceled;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public boolean isCanceled() {
        return canceled;
    }

    public void setCanceled(boolean canceled) {
        this.canceled = canceled;
    }
}
