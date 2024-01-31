package org.rak.transaction.unit.transaction;

import jakarta.validation.Valid;
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

import java.util.List;

@RestController
@RequestMapping(path = "/transaction")
public class TransactionController {

	private final BusinessService<TransactionDto> businessService;
	private final TransactionService transactionService;

	public TransactionController(BusinessService<TransactionDto> businessService, TransactionService transactionService) {
		this.businessService = businessService;
		this.transactionService = transactionService;
	}


	@GetMapping("/student/{studentId}")
	public EndpointResponse<List<TransactionDto>> getAllByStudentId(@PathVariable String studentId){
		return new EndpointResponse<>(transactionService.getAllByStudentId(studentId),null);
	}

	@PostMapping
	public EndpointResponse<TransactionDto> processPayment(@Valid @RequestBody TransactionDto transactionDto){
		return new EndpointResponse<>(businessService.create(transactionDto), null);
	}

	@GetMapping("/test")
	EndpointResponse<Void> test(){
		transactionService.testJasper();
		return new EndpointResponse<>(null, null);
	}

}
