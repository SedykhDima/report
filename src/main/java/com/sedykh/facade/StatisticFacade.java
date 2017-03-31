package com.sedykh.facade;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by dima on 31.03.17.
 */
@Repository
public class StatisticFacade {
  @PersistenceContext
  private EntityManager em;


  public List<Object[]> findBy(Long departmentId, Date from, Date to, Long delimiter) {
    StringBuilder sb = new StringBuilder();
    sb.append("SELECT TO_TIMESTAMP((dt + (60*delimiter - dt % (60*delimiter)))) ");
    sb.append("AT TIME ZONE 'UTC' as time_interval, SUM(value) ");
    sb.append(" FROM (SELECT report.value, ");
    sb.append(" CAST(EXTRACT(EPOCH ");
    sb.append(" FROM (report.create_date + CAST(( ");
    sb.append(
        " CAST(timezone.greenwich_deviation AS varchar) || ' hour')AS interval))) as bigint) as dt ");
    sb.append(" FROM report JOIN employee ON report.employee_id = employee.id ");
    sb.append(" JOIN department ON employee.department_id = department.id ");
    sb.append(" JOIN timezone ON department.timezone_id = timezone.id WHERE department.id IN ( ");
    sb.append(" WITH RECURSIVE d AS ( ");
    sb.append(" SELECT id, parent_id, name, timezone_id ");
    sb.append(" FROM department ");
    sb.append(" WHERE parent_id = :departmentId ");
    sb.append(" UNION ");
    sb.append(
        " SELECT department.id, department.parent_id, department.name, department.timezone_id ");
    sb.append(" FROM department ");
    sb.append(" JOIN d ON department.parent_id = d.id ");
    sb.append(" ) ");
    sb.append(" SELECT d.id FROM d ");
    sb.append(" )) AS report ");
    sb.append(" WHERE TO_TIMESTAMP(dt) AT TIME ZONE 'UTC' <= :to ");
    sb.append(" AND TO_TIMESTAMP(dt) AT TIME ZONE 'UTC' >= :from ");
    sb.append(" GROUP BY dt  + (60*delimiter - dt % (60*delimiter)) ");
    sb.append(" ORDER BY dt  + (60*delimiter - dt % (60*delimiter)); ");

    Query query = em.createNativeQuery(sb.toString().replaceAll("delimiter", delimiter + ""));

    query.setParameter("departmentId", departmentId);
    query.setParameter("from", from);
    query.setParameter("to", to);

    return query.getResultList();
  }
}
