package com.globalpayment.payment.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.globalpayment.payment.entity.Payment;
import com.globalpayment.payment.repository.IPaymentRepo;

import jakarta.validation.Valid;



@RestController
@RequestMapping("/api")
public class PaymentController {

    @Autowired
    IPaymentRepo paymentRepo;

    @GetMapping("/payments")
	public ResponseEntity<List<Payment>> getAllTransaction() {
		try {
			List<Payment> list = paymentRepo.findAll();
			
			if (list.isEmpty() || list.size() == 0) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


    @GetMapping("/payments/{id}")
	public ResponseEntity<Payment> getTransaction(@PathVariable Long id) {
		Optional<Payment> transaction = paymentRepo.findById(id);
		
		if (transaction.isPresent()) {
			return new ResponseEntity<>(transaction.get(), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	

    @PostMapping("/payments")
    public ResponseEntity<Payment> saveCustomer(@RequestBody @Valid Payment payment) {
		try {
			return new ResponseEntity<>(paymentRepo.save(payment), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
    
    @GetMapping("/home")
	public String home(){
        return "Ok.";
    }
	
}
