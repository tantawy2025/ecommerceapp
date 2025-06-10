package com.eg.ecommerce_v1.repo;

import com.eg.ecommerce_v1.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
