package com.mphasis.main.cui;

import com.mphasis.entities.Certificate;
import com.mphasis.entities.Employee;
import oracle.jdbc.driver.OracleDriver;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.sql.DriverManager;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


public class Main {
    private static SessionFactory factory;

    public static void main(String[] args){

        Session session;
        try {
            factory = new Configuration().configure().buildSessionFactory();
            session = factory.openSession();
        }catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
            Main main = new Main();

            /* Let us have a set of certificates for the first employee  */
            HashSet set1 = new HashSet();
            set1.add(new Certificate("MCA"));
            set1.add(new Certificate("MBA"));
            set1.add(new Certificate("PMP"));

            /* Add employee records in the database */
            Integer empID1 = main.addEmployee("Manoj", "Kumar", 4000, set1);

            /* Another set of certificates for the second employee  */
            HashSet set2 = new HashSet();
            set2.add(new Certificate("BCA"));
            set2.add(new Certificate("BA"));

            /* Add another employee record in the database */
            Integer empID2 = main.addEmployee("Dilip", "Kumar", 3000, set2);

            /* List down all the employees */
            main.listEmployees();

            /* Update employee's salary records */
            main.updateEmployee(empID1, 5000);

            /* Delete an employee from the database */
            main.deleteEmployee(empID2);

            /* List down all the employees */
            main.listEmployees();


        String hql = "SELECT  E.firstName FROM com.mphasis.entities.Employee E";
        Query query = session.createQuery(hql);
        List results = query.list();

        hql = "UPDATE com.mphasis.entities.Employee set salary = :salary "  +
                "WHERE id = :employee_id";
        query = session.createQuery(hql);
        Transaction transaction = session.beginTransaction();
        query.setParameter("salary", 1000);
        query.setParameter("employee_id", 1);
        int result = query.executeUpdate();
        transaction.commit();
        System.out.println("Rows affected: " + result);
        }



        public Integer addEmployee(String fname, String lname, int salary, Set cert){
            Session session = factory.openSession();
            Transaction tx = null;
            Integer employeeID = null;

            try {
                tx = session.beginTransaction();
                Employee employee = new Employee(fname, lname, salary);
                employee.setCertificates(cert);
                employeeID = (Integer) session.save(employee);
                tx.commit();
            } catch (HibernateException e) {
                if (tx!=null) tx.rollback();
                e.printStackTrace();
            } finally {
                session.close();
            }
            return employeeID;
        }

        /* Method to list all the employees detail */
        public void listEmployees( ){
            Session session = factory.openSession();
            Transaction tx = null;

            try {
                tx = session.beginTransaction();
                List employees = session.createQuery("FROM Employee").list();
                for (Iterator iterator1 = employees.iterator(); iterator1.hasNext();){
                    Employee employee = (Employee) iterator1.next();
                    System.out.print("First Name: " + employee.getFirstName());
                    System.out.print("  Last Name: " + employee.getLastName());
                    System.out.println("  Salary: " + employee.getSalary());
                    Set certificates = employee.getCertificates();
                    for (Iterator iterator2 = certificates.iterator(); iterator2.hasNext();){
                        Certificate certName = (Certificate) iterator2.next();
                        System.out.println("Certificate: " + certName.getName());
                    }
                }
                tx.commit();
            } catch (HibernateException e) {
                if (tx!=null) tx.rollback();
                e.printStackTrace();
            } finally {
                session.close();
            }
        }

        /* Method to update salary for an employee */
        public void updateEmployee(Integer EmployeeID, int salary ){
            Session session = factory.openSession();
            Transaction tx = null;
            try {
                tx = session.beginTransaction();
                Employee employee = (Employee)session.get(Employee.class, EmployeeID);
                employee.setSalary( salary );
                session.update(employee);
                tx.commit();
            } catch (HibernateException e) {
                if (tx!=null) tx.rollback();
                e.printStackTrace();
            } finally {
                session.close();
            }
        }

        /* Method to delete an employee from the records */
        public void deleteEmployee(Integer EmployeeID){
            Session session = factory.openSession();
            Transaction tx = null;

            try {
                tx = session.beginTransaction();
                Employee employee = (Employee)session.get(Employee.class, EmployeeID);
                session.delete(employee);
                tx.commit();
            } catch (HibernateException e) {
                if (tx!=null) tx.rollback();
                e.printStackTrace();
            } finally {
                session.close();
            }
        }
}
