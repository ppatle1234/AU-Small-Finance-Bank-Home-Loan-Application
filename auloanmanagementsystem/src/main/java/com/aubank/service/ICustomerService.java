package com.aubank.service;

import com.aubank.model.Customer;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {

    Customer save(Customer customer);

    boolean signIn(String custEmailId, String custPassword);

    Optional<Customer> findById(long custId);

    List<Customer> findAll();

    Customer update(long custId, Customer customer);

    void deleteById(long custId);

    void deleteAll();
}
