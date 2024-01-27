package org.rak.microservicesassessment.unit.student;

/**
 * @author Usman
 * @created 1/23/2024 - 12:50 AM
 * @project Microservices-assessment
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder(toBuilder = true)
public class StudentDto {

	@NotBlank @JsonProperty("uuid") private String uuid;
	@NotBlank @JsonProperty("studentName") private String studentName;
	@NotBlank @JsonProperty("studentId") private String studentId;
	@NotBlank @JsonProperty("MobileNumber") private String MobileNumber;
	@NotBlank @JsonProperty("guardian") private String guardian;
	@NotBlank @JsonProperty("grade") private String grade;
}
