package com.sedykh.repository;

import com.sedykh.entity.Timezone;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by dima on 22.03.17.
 */
public interface TimezoneRepository extends JpaRepository<Timezone, Long> {

}
