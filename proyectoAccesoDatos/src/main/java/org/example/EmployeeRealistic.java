package org.example;

import jakarta.persistence.*;

@Entity
@Table(name = "employees_realistic")
public class EmployeeRealistic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employees_realistic_id")
    private Long employeesRealisticId;
    @Column(name = "employee_id")
    private int employeeId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "department_id")
    private int departmentId;
    @Column(name = "hire_date")
    private String hireDate;
    @Column(name = "salary")
    private Double salary;
    @Column(name = "position")
    private String position;

    // Getters and Setters
    public Long getEmployeesRealisticId() {
        return employeesRealisticId;
    }

    public void setEmployeesRealisticId(Long employeesRealisticId) {
        this.employeesRealisticId = employeesRealisticId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
