package com.sedykh.repository;

import com.sedykh.entity.Report;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by dima on 31.03.17.
 */
@Transactional
@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {

}
