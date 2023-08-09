package com.springboot.webfluxapp.services;

import com.springboot.webfluxapp.entities.TaskSchedule;
import com.springboot.webfluxapp.repositories.TaskScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TaskScheduleService {

    private final TaskScheduleRepository taskScheduleRepository;

    @Autowired
    public TaskScheduleService(TaskScheduleRepository taskScheduleRepository) {
        this.taskScheduleRepository = taskScheduleRepository;
    }
    public Mono<TaskSchedule> create(TaskSchedule taskSchedule){
       return taskScheduleRepository.save(taskSchedule);
    }

    public Mono<TaskSchedule> update(TaskSchedule updatedTaskSchedule, int id){
        return taskScheduleRepository.findById(id)
                .flatMap(taskSchedule -> {
                            taskSchedule.setEmployeeName(updatedTaskSchedule.getEmployeeName());
                            taskSchedule.setTaskDate(updatedTaskSchedule.getTaskDate());
                            taskSchedule.setAssignedTask(updatedTaskSchedule.getAssignedTask());
                            taskSchedule.setTaskDetails(updatedTaskSchedule.getTaskDetails());
                            return taskScheduleRepository.save(taskSchedule);
                        });
    }


    public Mono<Void> deleteById(int id) {
        return taskScheduleRepository.deleteById(id);
    }

    public Flux<TaskSchedule> getAllTaskSchedule() {
        return taskScheduleRepository.findAll();
    }

    public Mono<TaskSchedule> getTaskSchedule(int id) {
        return taskScheduleRepository.findById(id);

    }
}
