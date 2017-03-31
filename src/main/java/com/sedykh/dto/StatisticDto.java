package com.sedykh.dto;

import java.util.Date;

/**
 * Created by dima on 31.03.17.
 */
public class StatisticDto {
  private Long value;
  private Date interval;

  public Long getValue() {
    return value;
  }

  public void setValue(Long value) {
    this.value = value;
  }

  public Date getInterval() {
    return interval;
  }

  public void setInterval(Date interval) {
    this.interval = interval;
  }
}
