package com.sedykh.utils;

import com.sedykh.dto.DepartmentDto;
import com.sedykh.dto.EmployeeDto;
import com.sedykh.dto.StatisticDto;
import com.sedykh.entity.Department;
import com.sedykh.entity.Employee;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by dima on 31.03.17.
 */
public class DtoEntityMapper {

  public static EmployeeDto map(Employee employee) {
    EmployeeDto dto = new EmployeeDto();
    dto.setId(employee.getId());
    dto.setName(employee.getName());

    return dto;
  }

  public static List<EmployeeDto> mapEmployees(Iterable<Employee> employees) {
    List<EmployeeDto> result = new ArrayList<>();

    for (Employee employee : employees) {
      result.add(map(employee));
    }

    return result;
  }

  public static List<StatisticDto> mapStatistics(Iterable<Object[]> statistic) {
    List<StatisticDto> result = new ArrayList<>();
    for (Object[] objects : statistic) {
      StatisticDto dto = new StatisticDto();
      for (Object element : objects) {
        if (element instanceof Date) {
          dto.setInterval((Date) element);
        } else if (element instanceof BigDecimal) {
          dto.setValue(((BigDecimal) element).longValue());
        }
      }
      result.add(dto);
    }

    return result;
  }

  public static List<DepartmentDto> mapDepartments(Iterable<Department> departments) {
    List<DepartmentDto> result = new ArrayList<>();
    for (Department department : departments) {
      result.add(map(department));
    }
    return result;
  }

  public static DepartmentDto map(Department department) {
    DepartmentDto dto = new DepartmentDto();
    dto.setName(department.getName());
    dto.setId(department.getId());

    return dto;
  }
}
