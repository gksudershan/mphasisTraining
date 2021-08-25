package com.mphasis.main.cui;

import com.mphasis.entities.Employee;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Iterator;
import java.util.List;


public class Main {
    private static SessionFactory factory;

    public static void main(String[] args){

        try {
            factory = new Configuration().configure().buildSessionFactory();
            Main main = new Main();

            /* Add few employee records in database */
            Integer empID1 = main.addEmployee("Zara", "Ali", 1000);
            Integer empID2 = main.addEmployee("Daisy", "Das", 5000);
            Integer empID3 = main.addEmployee("John", "Paul", 10000);

            main.listEmployees();;
            main.updateEmployee(empID1,10000);
            main.deleteEmployee(empID2);
            main.listEmployees();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }

        System.out.println("Factory...");
    }

    public Integer addEmployee(String fname, String lname, int salary){
        Session session = factory.openSession();
        Transaction transaction = null;
        Integer employeeID = null;

        try {
            transaction = session.beginTransaction();
            Employee employee = new Employee(fname, lname, salary);
            employeeID = (Integer) session.save(employee);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction!=null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return employeeID;
    }

    public void listEmployees( ){
        Session session = factory.openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            List employees = session.createQuery("FROM Employee").list();
            for (Iterator iterator = employees.iterator(); iterator.hasNext();){
                Employee employee = (Employee) iterator.next();
                System.out.print("First Name: " + employee.getFirstName());
                System.out.print("  Last Name: " + employee.getLastName());
                System.out.println("  Salary: " + employee.getSalary());
            }
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction!=null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    /* Method to UPDATE salary for an employee */
    public void updateEmployee(Integer EmployeeID, int salary ){
        Session session = factory.openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            Employee employee = (Employee)session.get(Employee.class, EmployeeID);
            employee.setSalary( salary );
            session.update(employee);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction!=null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    /* Method to DELETE an employee from the records */
    public void deleteEmployee(Integer EmployeeID){
        Session session = factory.openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            Employee employee = (Employee)session.get(Employee.class, EmployeeID);
            session.delete(employee);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction!=null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
