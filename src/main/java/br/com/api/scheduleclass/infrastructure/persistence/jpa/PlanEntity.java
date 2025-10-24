package br.com.api.scheduleclass.infrastructure.persistence.jpa;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "plan")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlanEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(name = "monthly_limit")
    private Integer monthlyLimit; // null = ilimitado

    @Column(precision = 10, scale = 2)
    private BigDecimal price;

    @Column(length = 255)
    private String description;
}
