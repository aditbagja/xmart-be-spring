package com.app.xmartbe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.xmartbe.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {

}
