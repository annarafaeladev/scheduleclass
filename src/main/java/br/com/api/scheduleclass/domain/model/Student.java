package br.com.api.scheduleclass.domain.model;

import java.time.LocalDateTime;

public class Student extends Base {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private boolean active;
    private int beltDegree;
    private int totalBookings = 0;
    private Academy academy;
    private Belt belt;
    private Plan plan;


    public Student() {
        super(LocalDateTime.now(), LocalDateTime.now());
    }

    public Student(Long id, String name, String email, String phone, boolean active, int beltDegree, int totalBookings, Academy academy, Belt belt, Plan plan, LocalDateTime createdAt, LocalDateTime updatedAt) {
        super(createdAt, updatedAt);
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.active = active;
        this.beltDegree = beltDegree;
        this.totalBookings = totalBookings;
        this.academy = academy;
        this.belt = belt;
        this.plan = plan;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getBeltDegree() {
        return beltDegree;
    }

    public void setBeltDegree(int beltDegree) {
        this.beltDegree = beltDegree;
    }

    public int getTotalBookings() {
        return totalBookings;
    }

    public void setTotalBookings(int totalBookings) {
        this.totalBookings = totalBookings;
    }

    public Academy getAcademy() {
        return academy;
    }

    public void setAcademy(Academy academy) {
        this.academy = academy;
    }

    public Belt getBelt() {
        return belt;
    }

    public void setBelt(Belt belt) {
        this.belt = belt;
    }

    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }
}
