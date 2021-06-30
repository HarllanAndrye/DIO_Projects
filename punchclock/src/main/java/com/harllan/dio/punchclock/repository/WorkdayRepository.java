package com.harllan.dio.punchclock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.harllan.dio.punchclock.entity.Workday;

@Repository
public interface WorkdayRepository extends JpaRepository<Workday, Long> {

}
