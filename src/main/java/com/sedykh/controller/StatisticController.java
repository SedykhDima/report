package com.sedykh.controller;

import com.sedykh.dto.DepartmentDto;
import com.sedykh.dto.StatisticDto;
import com.sedykh.facade.StatisticFacade;
import com.sedykh.repository.DepartmentRepository;
import com.sedykh.utils.DtoEntityMapper;
import java.util.Calendar;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by dima on 31.03.17.
 */
@RestController
@RequestMapping("/statistic")
public class StatisticController {

  @Autowired
  private StatisticFacade statisticFacade;

  @Autowired
  private DepartmentRepository departmentRepository;


  @RequestMapping(value = "/get_all_department", method = RequestMethod.GET)
  public List<DepartmentDto> getDepartments() {
    return DtoEntityMapper.mapDepartments(departmentRepository.findAll());
  }

  @RequestMapping(value = "/get_statistic", method = RequestMethod.GET)
  public List<StatisticDto> getStatistic(@Param("departmentId") Long departmentId,
      @Param("delimiter") Long delimiter) {
    Calendar from = getCurrentDateZeroCalendar();
    from.set(Calendar.HOUR_OF_DAY, 9);
    Calendar to = getCurrentDateZeroCalendar();
    to.set(Calendar.HOUR_OF_DAY, 20);
    List<Object[]> statistics = statisticFacade.findBy(departmentId, from.getTime(), to.getTime(), delimiter);

    return DtoEntityMapper.mapStatistics(statistics);
  }

  private Calendar getCurrentDateZeroCalendar() {
    Calendar calendar = Calendar.getInstance();
    calendar.set(Calendar.HOUR_OF_DAY, 0);
    calendar.set(Calendar.MINUTE, 0);
    calendar.set(Calendar.SECOND, 0);
    calendar.set(Calendar.MILLISECOND, 0);

    return calendar;
  }
}
