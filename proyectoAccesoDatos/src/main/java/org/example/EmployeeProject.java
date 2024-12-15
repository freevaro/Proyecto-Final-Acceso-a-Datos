package org.example;

import jakarta.persistence.*;

@Entity
@Table(name = "employee_projects")
public class EmployeeProject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_projects_id")
    private int employeeProjectsId;
    @Column(name = "employee_id")
    private int employeeId;
    @Column(name = "project_id")
    private int projectId;
    @Column(name = "hours_worked")
    private Double hoursWorked;

    // Getters and Setters
    public int getEmployeeProjectsId() {
        return employeeProjectsId;
    }

    public void setEmployeeProjectsId(int employeeProjectsId) {
        this.employeeProjectsId = employeeProjectsId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public Double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(Double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }
}