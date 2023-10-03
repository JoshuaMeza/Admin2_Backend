package com.gate_software.ams_backend.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

public class ControlledUserListDTO {
    private Integer id;
    private String name;
    private String email;
    private float salary;

    @JsonIgnore
    private JobDTO job;
    private String jobDescription;
    private boolean present;

    private List<String> schedules;

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public void setJob(JobDTO job) {
        this.job = job;
    }

    public void setPresent(boolean present) {
        this.present = present;
    }

    public void setSchedules(List<String> schedules) {
        this.schedules = schedules;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public float getSalary() {
        return salary;
    }

    public JobDTO getJob() {
        return job;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public boolean isPresent() {
        return present;
    }

    public List<String> getSchedules() {
        return this.schedules;
    }
}
