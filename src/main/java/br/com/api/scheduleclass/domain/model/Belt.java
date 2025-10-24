package br.com.api.scheduleclass.domain.model;

public class Belt {
    private Long id;
    private String name;
    private int order_level;

    public Belt() {}

    public Belt(Long id, String name, int order_level) {
        this.id = id;
        this.name = name;
        this.order_level = order_level;
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

    public int getOrder_level() {
        return order_level;
    }

    public void setOrder_level(int order_level) {
        this.order_level = order_level;
    }
}
