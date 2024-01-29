package org.rak.transaction.unit.fee;

import org.rak.transaction.dto.EndpointResponse;
import org.rak.transaction.interfaces.BusinessService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/fee")
public class FeeController {

	private BusinessService<FeeDto> businessService;
	private FeeServiceImpl feeService;

	public FeeController(BusinessService<FeeDto> businessService, FeeServiceImpl feeService) {
		this.businessService = businessService;
		this.feeService = feeService;
	}


	@GetMapping("/type/{type}/sub-type/{subType}")
	EndpointResponse<FeeDto> getFeeByTypeAndSubType(@PathVariable String type,
											  @PathVariable String subType){
		return new EndpointResponse<>(feeService.getByTypeAndSubType(type, subType),null);
	}

	@PostMapping
	EndpointResponse<FeeDto> addFee(@RequestBody FeeDto feeDto){
		return new EndpointResponse<>(businessService.create(feeDto), null);
	}

	@PutMapping
	EndpointResponse<FeeDto> updateStudent(@RequestBody FeeDto feeDto, @PathVariable String uuid){
		return new EndpointResponse<>(businessService.update(feeDto, uuid), null);
	}

	@DeleteMapping
	void updateStudent(@PathVariable String uuid){
		businessService.delete(uuid);
	}

}
