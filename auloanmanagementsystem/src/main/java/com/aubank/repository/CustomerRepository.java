package com.aubank.repository;

import com.aubank.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer findByCustomerEmailIdAndCustomerPassword(String customerEmailId, String customerPassword);
}
