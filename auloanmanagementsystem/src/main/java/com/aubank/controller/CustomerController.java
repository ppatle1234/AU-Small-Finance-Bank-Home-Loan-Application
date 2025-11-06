package com.aubank.controller;

import com.aubank.model.Customer;
import com.aubank.service.ICustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
@Slf4j
public class CustomerController {

    private final ICustomerService customerService;

    @PostMapping("/signup")
    public ResponseEntity<Customer> signUp(@RequestBody Customer customer){
        return new ResponseEntity<>(customerService.save(customer), HttpStatus.CREATED);
    }

    @GetMapping("/signin/{customerEmailId}/{customerPassword}")
    public ResponseEntity<Boolean> signIn(@PathVariable String customerEmailId, @PathVariable String customerPassword){
        return new ResponseEntity<>(customerService.signIn(customerEmailId, customerPassword), HttpStatus.OK);
    }

    @GetMapping("/findbyid/{customerId}")
    public ResponseEntity<Optional<Customer>> findById(@PathVariable long customerId){
        return new ResponseEntity<>(customerService.findById(customerId), HttpStatus.OK);
    }

    @GetMapping("/findall")
    public ResponseEntity<List<Customer>> findAll(){
        return new ResponseEntity<>(customerService.findAll(), HttpStatus.OK);
    }

    @PutMapping("/update/{customerId}")
    public ResponseEntity<Customer> update(@PathVariable long customerId, @RequestBody Customer customer){
        return new ResponseEntity<>(customerService.update(customerId, customer), HttpStatus.CREATED);
    }

    @DeleteMapping("/deletebyid/{customerId}")
    public ResponseEntity<String> deleteById(@PathVariable long customerId){
        customerService.deleteById(customerId);
        return new ResponseEntity<>("Data Successfully Deleted.", HttpStatus.OK);
    }

    @DeleteMapping("/deleteall")
    public ResponseEntity<String> deleteAll(){
        customerService.deleteAll();
        return new ResponseEntity<>("All Data Deleted Successfully.", HttpStatus.OK);
    }
}
