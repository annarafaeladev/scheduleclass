package br.com.api.scheduleclass.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Plan extends Base {
    private Long id;
    private String name;
    private int monthlyLimit;
    private BigDecimal price;
    private String description;

    public Plan() {
        super(LocalDateTime.now(), LocalDateTime.now());
    }

    public Plan(Long id, String name, int monthlyLimit, BigDecimal price, String description, LocalDateTime createdAt, LocalDateTime updatedAt) {
        super(createdAt, updatedAt);
        this.id = id;
        this.name = name;
        this.monthlyLimit = monthlyLimit;
        this.price = price;
        this.description = description;
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

    public int getMonthlyLimit() {
        return monthlyLimit;
    }

    public void setMonthlyLimit(int monthlyLimit) {
        this.monthlyLimit = monthlyLimit;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
