package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.entities.EmployeeMaster;

@Repository
public interface EmployeeMasterRepository extends JpaRepository<EmployeeMaster,Integer> {

}
