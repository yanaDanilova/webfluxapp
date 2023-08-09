package com.springboot.webfluxapp.controllers;
import com.springboot.webfluxapp.entities.TaskSchedule;
import com.springboot.webfluxapp.services.TaskScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;



@RestController
@RequestMapping("/api/taskSchedules")
public class TaskScheduleController {
    private final TaskScheduleService taskScheduleService;

    @Autowired
    public TaskScheduleController(TaskScheduleService taskScheduleService) {
        this.taskScheduleService = taskScheduleService;
    }

    @GetMapping()
    public Flux<TaskSchedule> getAllTaskSchedule(){
        return taskScheduleService.getAllTaskSchedule();
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<TaskSchedule>> getTaskScheduleById(@PathVariable int id){
        return taskScheduleService.getTaskSchedule(id).map(TaskSchedule->ResponseEntity.ok().body(TaskSchedule))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }
    @PostMapping
    public Mono<TaskSchedule> createTaskSchedule(@RequestBody TaskSchedule taskSchedule){
       return taskScheduleService.create(taskSchedule);
    }
    @PutMapping("/{id}")

    public Mono<TaskSchedule> updateTaskSchedule(@RequestBody TaskSchedule updatedTaskSchedule, @PathVariable int id){
      return taskScheduleService.update(updatedTaskSchedule,id);
    }
    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Object>> deleteTaskScheduleById(@PathVariable int id){
        return taskScheduleService.deleteById(id)
                .then(Mono.just(ResponseEntity.noContent().build()))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
}
