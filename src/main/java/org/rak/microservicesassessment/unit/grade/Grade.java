package org.rak.microservicesassessment.unit.grade;

/**
 * @author Usman
 * @created 1/23/2024 - 1:59 AM
 * @project Microservices-assessment
 */

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder(toBuilder = true)
@Entity
@Table(name = "grade")
public class Grade {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
	private String grade;

}
