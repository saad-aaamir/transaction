package org.rak.microservicesassessment.unit.student;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Usman
 * @created 1/23/2024 - 1:22 AM
 * @project Microservices-assessment
 */
public interface StudentRepository extends JpaRepository<Student, Long> {
	Boolean existsByGradeAndStudentId(String grade, String studentId);
}
