package com.sedykh.repository;

import com.sedykh.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by dima on 22.03.17.
 */
public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
