package org.example;

import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class Consultas {
    public List<Object[]> consultab() {
        Session session = ConexionBBDD.getSessionFactory().openSession();
        session.beginTransaction();

        String hql = "SELECT ep.employeeId, er.salary, ep.projectId "
                + "FROM EmployeeProject ep "
                + "JOIN EmployeeRealistic er ON ep.employeeId = er.employeeId";

        Query<Object[]> query = session.createQuery(hql, Object[].class);
        List<Object[]> results = query.getResultList();

        for (Object[] row : results) {
            int employeeId = (int) row[0];
            Double salary = (Double) row[1];
            int projectId = (int) row[2];
            System.out.println("Employee ID: " + employeeId + ", Salary: " + salary + ", Project ID: " + projectId);
        }
        session.close();
        return results;
    }

    public List<Object[]> consultac() {
        Session session = ConexionBBDD.getSessionFactory().openSession();

        String hql = "SELECT ep.projectId, er.salary, ep.hoursWorked "
                + "FROM EmployeeProject ep "
                + "JOIN EmployeeRealistic er ON ep.employeeId = er.employeeId";

        Query<Object[]> query = session.createQuery(hql, Object[].class);
        List<Object[]> results = query.getResultList();

        double totalCost = 0.0;
        for (Object[] row : results) {
            Double salary = (Double) row[1];
            Double hoursWorked = (Double) row[2];

            double hourlySalary = salary / 1900; // Salario por hora
            double cost = hourlySalary * hoursWorked;
            totalCost += cost;
        }

        System.out.println("Total Salary Costs: " + totalCost);
        session.close();
        return results;
    }

    public List<Object[]> consultd(){
        Session session = ConexionBBDD.getSessionFactory().openSession();

        String hql = "SELECT ep.projectId, SUM(er.salary * ep.hoursWorked / 1900), p.budget "
                + "FROM EmployeeProject ep "
                + "JOIN EmployeeRealistic er ON ep.employeeId = er.employeeId "
                + "JOIN Project p ON ep.projectId = p.projectId "
                + "GROUP BY ep.projectId, p.budget";

        Query<Object[]> query = session.createQuery(hql, Object[].class);
        List<Object[]> results = query.getResultList();

        for (Object[] row : results) {
            int projectId = (int) row[0];
            Double salaryCosts = (Double) row[1]; // Cambiado a Double
            Double budget = (Double) row[2];      // Cambiado a Double
            System.out.println("Project ID: " + projectId + ", Salary Costs: " + salaryCosts + ", Budget: " + budget);
        }


        session.close();
        return results;
    }

    public List<Object[]> consultae(){
        Session session = ConexionBBDD.getSessionFactory().openSession();

        String hql = "SELECT ep.projectId, SUM(er.salary * ep.hoursWorked / 19), p.budget "
                + "FROM EmployeeProject ep "
                + "JOIN EmployeeRealistic er ON ep.employeeId = er.employeeId "
                + "JOIN Project p ON ep.projectId = p.projectId "
                + "GROUP BY ep.projectId, p.budget";

        Query<Object[]> query = session.createQuery(hql, Object[].class);
        List<Object[]> results = query.getResultList();

        for (Object[] row : results) {
            int projectId = (int) row[0];
            Double salaryCosts = (Double) row[1];
            Double budget = (Double) row[2];

            double fraction = salaryCosts / budget;
            System.out.println("Project ID: " + projectId + ", Salary Costs Fraction: " + fraction);
        }

        session.close();
        return results;
    }
}
