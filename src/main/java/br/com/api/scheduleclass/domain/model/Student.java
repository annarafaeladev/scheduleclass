package br.com.api.scheduleclass.domain.model;

import java.time.LocalDateTime;

public class Student {
    private Long id;
    private Long academyId;
    private String name;
    private String email;
    private String phone;
    private Long belt_id;
    private Long plan_id;
    private boolean active;
    private LocalDateTime createAt;


    public Student() {}

    public Student(Long id, Long academyId, String name, String email, String phone, Long belt_id, Long plan_id, boolean active, LocalDateTime createAt) {
        this.id = id;
        this.academyId = academyId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.belt_id = belt_id;
        this.plan_id = plan_id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Long getBelt_id() {
        return belt_id;
    }

    public void setBelt_id(Long belt_id) {
        this.belt_id = belt_id;
    }

    public Long getPlan_id() {
        return plan_id;
    }

    public void setPlan_id(Long plan_id) {
        this.plan_id = plan_id;
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
