package com.aubank.service;

import com.aubank.exception.RecordNotFoundException;
import com.aubank.model.Customer;
import com.aubank.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements ICustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public boolean signIn(String customerEmailId, String customerPassword) {

        Customer customer = customerRepository.findByCustomerEmailIdAndCustomerPassword(customerEmailId, customerPassword);
        return customer != null;
    }

    @Override
    public Optional<Customer> findById(long customerId) {
        return Optional.ofNullable(customerRepository.findById(customerId).orElseThrow(() -> new RecordNotFoundException("Customer ID Does Not Exist.")));
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer update(long customerId, Customer customer) {

        Customer customer1 = findById(customerId).get();

        customer1.setCustomerFirstName(customer.getCustomerFirstName());
        customer1.setCustomerLastName(customer.getCustomerLastName());
        customer1.setCustomerAddress(customer.getCustomerAddress());
        customer1.setCustomerGender(customer.getCustomerGender());
        customer1.setCustomerAdharNumber(customer.getCustomerAdharNumber());
        customer1.setCustomerPanNumber(customer.getCustomerPanNumber());
        customer1.setCustomerDOB(customer.getCustomerDOB());
        customer1.setCustomerContactNumber(customer.getCustomerContactNumber());
        customer1.setCustomerEmailId(customer.getCustomerEmailId());
        customer1.setCustomerPassword(customer.getCustomerPassword());
        return customerRepository.save(customer1);
    }

    @Override
    public void deleteById(long customerId) {
        customerRepository.deleteById(customerId);
    }

    @Override
    public void deleteAll() {
       customerRepository.deleteAll();
    }
}
