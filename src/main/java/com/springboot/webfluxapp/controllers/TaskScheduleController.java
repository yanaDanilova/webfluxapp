package com.springboot.webfluxapp.controllers;
import com.springboot.webfluxapp.entities.TaskSchedule;
import com.springboot.webfluxapp.services.TaskScheduleService;
import io.swagger.v3.oas.annotations.Operation;
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
    @Operation(description = "get the entire list of task schedule")
    public Flux<TaskSchedule> getAllTaskSchedule(){
        return taskScheduleService.getAllTaskSchedule();
    }

    @GetMapping("/{id}")
    @Operation(description = "get a task schedule by ID")
    public Mono<ResponseEntity<TaskSchedule>> getTaskScheduleById(@PathVariable int id){
        return taskScheduleService.getTaskSchedule(id).map(TaskSchedule->ResponseEntity.ok().body(TaskSchedule))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }
    @PostMapping
    @Operation(description = "Create a new Task Schedule")
    public Mono<TaskSchedule> createTaskSchedule(@RequestBody TaskSchedule taskSchedule){
       return taskScheduleService.create(taskSchedule);
    }
    @PutMapping("/{id}")
    @Operation(description = "Update the existing task schedule")
    public Mono<TaskSchedule> updateTaskSchedule(@RequestBody TaskSchedule updatedTaskSchedule, @PathVariable int id){
      return taskScheduleService.update(updatedTaskSchedule,id);
    }
    @DeleteMapping("/{id}")
    @Operation(description = "Delete the existing task schedule by ID")
    public Mono<ResponseEntity<Object>> deleteTaskScheduleById(@PathVariable int id){
        return taskScheduleService.deleteById(id)
                .then(Mono.just(ResponseEntity.noContent().build()))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
}
