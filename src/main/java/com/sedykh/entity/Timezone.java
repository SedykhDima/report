package com.sedykh.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by dima on 21.03.17.
 */
@Entity
@Table(name = "timezone")
public class Timezone implements Serializable {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(name = "name", nullable = false, length = 255)
  private String name;

  @Column(name = "greenwich_deviation")
  private Long greenwichDeviation;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Long getGreenwichDeviation() {
    return greenwichDeviation;
  }

  public void setGreenwichDeviation(Long greenwichDeviation) {
    this.greenwichDeviation = greenwichDeviation;
  }
}
