package org.example;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ConexionBBDD {
    private static final SessionFactory sessionFactory;

    static {
        try {
            // Crear la SessionFactory desde la configuración de hibernate.cfg.xml
            sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(EmployeeProject.class)
                    .addAnnotatedClass(Project.class)
                    .addAnnotatedClass(OrderItem.class)
                    .addAnnotatedClass(EmployeeRealistic.class)
                    .addAnnotatedClass(Department.class)
                    .addAnnotatedClass(Customer.class)
                    .addAnnotatedClass(Order.class).buildSessionFactory();
        } catch (Exception e) {
            throw new ExceptionInInitializerError("Initial SessionFactory creation failed." + e);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        // Cerrar caché de Hibernate y conexiones a la base de datos
        getSessionFactory().close();
    }
}