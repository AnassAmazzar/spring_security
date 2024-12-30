package com.xproce.dao.repository;

import com.xproce.dao.entities.Customer;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Transactional
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    public List<Customer> findByEmail(String email);
}
