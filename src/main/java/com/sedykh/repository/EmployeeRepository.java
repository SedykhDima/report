package com.sedykh.repository;

import com.sedykh.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by dima on 22.03.17.
 */
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
