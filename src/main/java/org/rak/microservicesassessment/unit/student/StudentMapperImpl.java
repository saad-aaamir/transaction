package org.rak.microservicesassessment.unit.student;

import org.rak.microservicesassessment.interfaces.Mapper;

/**
 * @author Usman
 * @created 1/23/2024 - 12:46 AM
 * @project Microservices-assessment
 */
@org.rak.microservicesassessment.annotation.Mapper
public class StudentMapperImpl implements Mapper<StudentDto, Student> {
	@Override
	public StudentDto toDto(Student entity) {
	    StudentDto studentDto = StudentDto.builder()
	    		.uuid(entity.getUuid())
	    		.studentName(entity.getStudentName())
	    		.build();
	    return studentDto;

	}

	@Override
	public Student toEntity(StudentDto dto) {
	    Student student = Student.builder()
	    		.uuid(dto.getUuid())
	    		.studentName(dto.getStudentName())
	    		.build();
	    return student;

	}
}
