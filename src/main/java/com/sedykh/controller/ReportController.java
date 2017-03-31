package com.sedykh.controller;

import com.sedykh.dto.EmployeeDto;
import com.sedykh.entity.Report;
import com.sedykh.repository.EmployeeRepository;
import com.sedykh.repository.ReportRepository;
import com.sedykh.utils.DtoEntityMapper;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by dima on 31.03.17.
 */
@RestController
@RequestMapping("/report")
public class ReportController {

  @Autowired
  private EmployeeRepository employeeRepository;

  @Autowired
  private ReportRepository reportRepository;

  @RequestMapping(value = "/get_all_employee", method = RequestMethod.GET)
  public List<EmployeeDto> getAllEmployee() {
    return DtoEntityMapper.mapEmployees(employeeRepository.findAll());
  }

  @RequestMapping(value = "/save_report", method = RequestMethod.GET)
  @ResponseStatus(HttpStatus.OK)
  public void saveReport(@Param("employeeId") Long employeeId, @Param("value") Long value) {
    Report report = new Report();
    report.setValue(value);
    report.setEmployee(employeeRepository.findOne(employeeId));
    report.setCreateDate(getDate());
    reportRepository.save(report);
  }

  private Date getDate() {
    TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
    return new Date();
  }
}
