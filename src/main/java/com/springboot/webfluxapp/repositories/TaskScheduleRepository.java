package com.springboot.webfluxapp.repositories;

import com.springboot.webfluxapp.entities.TaskSchedule;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskScheduleRepository extends R2dbcRepository<TaskSchedule, Integer> {
}

