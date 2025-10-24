package br.com.api.scheduleclass.infrastructure.persistence.jpa;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "booking",
        uniqueConstraints = @UniqueConstraint(columnNames = {"class_id", "student_id", "booking_date"}))
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "class_id", nullable = false)
    private ClassScheduleEntity classSchedule;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", nullable = false)
    private StudentEntity student;

    @Column(name = "booking_date", nullable = false)
    private LocalDate bookingDate; // data específica da aula

    @Column(nullable = false)
    private Boolean canceled = false;
}
