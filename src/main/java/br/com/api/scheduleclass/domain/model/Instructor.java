package br.com.api.scheduleclass.domain.model;

import java.time.LocalDateTime;

public class Instructor extends Base {
    private Long id;
    private Long academyId;
    private String name;
    private String email;
    private String password;
    private String phone;
    private boolean isOwner;

    public Instructor(LocalDateTime createdAt, LocalDateTime updatedAt) {
        super(createdAt, updatedAt);
    }

    public Instructor(LocalDateTime createdAt, LocalDateTime updatedAt, Long id, Long academyId, String name, String email, String password, String phone, boolean isOwner) {
        super(createdAt, updatedAt);
        this.id = id;
        this.academyId = academyId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.isOwner = isOwner;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isOwner() {
        return isOwner;
    }

    public void setOwner(boolean owner) {
        isOwner = owner;
    }
}
