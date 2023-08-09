package com.springboot.webfluxapp.entities;

import jakarta.persistence.*;;
import org.springframework.data.annotation.Id;
import java.util.Date;

@Entity
public class TaskSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String employeeName;
    private Date taskDate;
    private String assignedTask;
    private String taskDetails;

    public TaskSchedule(int id, String employeeName, Date taskDate, String assignedTask, String taskDetails) {
        this.id = id;
        this.employeeName = employeeName;
        this.taskDate = taskDate;
        this.assignedTask = assignedTask;
        this.taskDetails = taskDetails;
    }

    public TaskSchedule() {
    }


    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public void setTaskDate(Date taskDate) {
        this.taskDate = taskDate;
    }

    public void setAssignedTask(String assignedTask) {
        this.assignedTask = assignedTask;
    }

    public void setTaskDetails(String taskDetails) {
        this.taskDetails = taskDetails;
    }

    public int getId() {
        return id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public Date getTaskDate() {
        return taskDate;
    }

    public String getAssignedTask() {
        return assignedTask;
    }

    public String getTaskDetails() {
        return taskDetails;
    }

    @Override
    public String toString() {
        return "TaskSchedule{" +
                "id=" + id +
                ", employeeName='" + employeeName + '\'' +
                ", taskDate=" + taskDate +
                ", assignedTask='" + assignedTask + '\'' +
                ", taskDetails='" + taskDetails + '\'' +
                '}';
    }
}

