package com.sedykh.entity;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Created by dima on 21.03.17.
 */
@Entity
@Table(name = "department")
public class Department implements Serializable {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(name = "name", nullable = false, length = 255)
  private String name;

  @JoinColumn(name = "parent_id", referencedColumnName = "id")
  @ManyToOne(cascade = CascadeType.PERSIST)
  private Department parent;

  @JoinColumn(name = "timezone_id", referencedColumnName = "id")
  @ManyToOne(fetch = FetchType.LAZY)
  private Timezone timezone;


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

  public Department getParent() {
    return parent;
  }

  public void setParent(Department parent) {
    this.parent = parent;
  }

  public Timezone getTimezone() {
    return timezone;
  }

  public void setTimezone(Timezone timezone) {
    this.timezone = timezone;
  }

}
