package org.rak.microservicesassessment.unit.student;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.rak.microservicesassessment.dto.EndpointResponse;
import org.rak.microservicesassessment.interfaces.BusinessService;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.*;

/**
 * @author Usman
 * @created 1/23/2024 - 12:43 AM
 * @project Microservices-assessment
 */


@ApiResponses(value = {
	@ApiResponses(code = 400, message = "Bad Request", response = ProblemDetail.class),
	@ApiResponse(code = 404, message = "Not Found", response = ProblemDetail.class),
	// Add more responses as needed
})
@RestController
@RequestMapping(path = "/student")
public class StudentController {

	private BusinessService<StudentDto> businessService;

	public StudentController(BusinessService<StudentDto> businessService) {
		this.businessService = businessService;
	}


	@GetMapping
	EndpointResponse<StudentDto> getStudentByUuid(@PathVariable String uuid){
		return new EndpointResponse<>(businessService.getbyUuid(uuid),null);
	}

	@PostMapping
	EndpointResponse<StudentDto> createStudent(@RequestBody StudentDto studentDto){
		return new EndpointResponse<>(businessService.create(studentDto), null);
	}

	@PutMapping
	EndpointResponse<StudentDto> updateStudent(@RequestBody StudentDto studentDto, @PathVariable String uuid){
		return new EndpointResponse<>(businessService.update(studentDto, uuid), null);
	}

	@DeleteMapping
	void updateStudent(@PathVariable String uuid){
		businessService.delete(uuid);
	}

}
