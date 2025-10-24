package br.com.api.scheduleclass.domain.model;

import java.time.LocalDateTime;

public class ClassSchedule {
    private Long id;
    private Long academyId;
    private Long instructorId;
    private String dayOfWeek;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private int maxStudents;
    private int beltMinLevel;
    private boolean active;
    private LocalDateTime createAt;

    public ClassSchedule() {
    }

    public ClassSchedule(Long id, Long academyId, Long instructorId, String dayOfWeek, LocalDateTime startTime, LocalDateTime endTime, int maxStudents, int beltMinLevel, boolean active, LocalDateTime createAt) {
        this.id = id;
        this.academyId = academyId;
        this.instructorId = instructorId;
        this.dayOfWeek = dayOfWeek;
        this.startTime = startTime;
        this.endTime = endTime;
        this.maxStudents = maxStudents;
        this.beltMinLevel = beltMinLevel;
        this.active = active;
        this.createAt = createAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAcademyId() {
        return academyId;
    }

    public void setAcademyId(Long academyId) {
        this.academyId = academyId;
    }

    public Long getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(Long instructorId) {
        this.instructorId = instructorId;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public int getMaxStudents() {
        return maxStudents;
    }

    public void setMaxStudents(int maxStudents) {
        this.maxStudents = maxStudents;
    }

    public int getBeltMinLevel() {
        return beltMinLevel;
    }

    public void setBeltMinLevel(int beltMinLevel) {
        this.beltMinLevel = beltMinLevel;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }
}
