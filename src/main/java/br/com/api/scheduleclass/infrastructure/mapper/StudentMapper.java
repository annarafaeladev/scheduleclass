package br.com.api.scheduleclass.infrastructure.mapper;

import br.com.api.scheduleclass.domain.model.Student;
import br.com.api.scheduleclass.infrastructure.persistence.jpa.StudentEntity;

public class StudentMapper {

    private StudentMapper(){}

    public static Student toDomain(StudentEntity entity) {
        return new Student(
                entity.getId(),
                entity.getName(),
                entity.getEmail(),
                entity.getPhone(),
                entity.getActive(),
                entity.getBeltDegree(),
                entity.getTotalBookings(),
                AcademyMapper.toDomain(entity.getAcademy()),
                BeltMapper.toDomain(entity.getBelt()),
                PlanMapper.toDomain(entity.getPlan()),
                entity.getCreatedAt(),
                entity.getUpdatedAt()

        );
    }

    public static StudentEntity toEntity(Student student) {
        StudentEntity entity = new StudentEntity();
        entity.setId(student.getId());
        entity.setName(student.getName());
        entity.setEmail(student.getEmail());
        entity.setPhone(student.getPhone());
        entity.setActive(student.isActive());
        entity.setBeltDegree(student.getBeltDegree());
        entity.setTotalBookings(student.getTotalBookings());
        entity.setAcademy(AcademyMapper.toEntity(student.getAcademy()));
        entity.setBelt(BeltMapper.toEntity(student.getBelt()));
        entity.setPlan(PlanMapper.toEntity(student.getPlan()));

        return entity;
    }
}
