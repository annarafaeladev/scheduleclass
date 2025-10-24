package br.com.api.scheduleclass.infrastructure.persistence.jpa;

import jakarta.persistence.*;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "belt")
@NoArgsConstructor
@AllArgsConstructor
public class BeltEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "order_level", nullable = false)
    private int orderLevel;
}