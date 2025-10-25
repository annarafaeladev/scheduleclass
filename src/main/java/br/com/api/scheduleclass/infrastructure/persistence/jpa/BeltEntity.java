package br.com.api.scheduleclass.infrastructure.persistence.jpa;

import br.com.api.scheduleclass.domain.enums.BeltLevel;
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

    @Column(name = "name", nullable = false, length = 10)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "belt_level", nullable = false)
    private BeltLevel beltLevel = BeltLevel.WHITE;

    @Column(name = "lessons_to_next", nullable = false)
    private int lessonsTonext = 0;
}