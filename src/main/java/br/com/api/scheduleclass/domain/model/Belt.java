package br.com.api.scheduleclass.domain.model;

import br.com.api.scheduleclass.domain.enums.BeltLevel;

import java.time.LocalDateTime;

public class Belt extends Base {
    private Long id;
    private String name;
    private BeltLevel beltLevel;
    private int lessonsTonext;

    public Belt() {
        super(LocalDateTime.now(), LocalDateTime.now());
    }

    public Belt(Long id, String name, BeltLevel beltLevel, int lessonsTonext, LocalDateTime createdAt, LocalDateTime updatedAt) {
        super(createdAt, updatedAt);
        this.id = id;
        this.name = name;
        this.beltLevel = beltLevel;
        this.lessonsTonext = lessonsTonext;
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

    public BeltLevel getBeltLevel() {
        return beltLevel;
    }

    public void setBeltLevel(BeltLevel beltLevel) {
        this.beltLevel = beltLevel;
    }

    public int getLessonsTonext() {
        return lessonsTonext;
    }

    public void setLessonsTonext(int lessonsTonext) {
        this.lessonsTonext = lessonsTonext;
    }
}
