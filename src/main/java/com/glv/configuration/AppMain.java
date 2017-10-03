/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.glv.configuration;

/**
 *
 * @author yftaich
 */
import com.glv.Model.Categorie;
import com.glv.configuration.AppConfig;
import com.glv.service.CategorieService;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

//@WebAppConfiguration
public class AppMain {

    public static void main(String args[]) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        CategorieService service = (CategorieService) context.getBean("categorieService");
        for (int i = 0; i < 5000; i++) {
            Categorie user = new Categorie();
            user.setCategorie("Youssef " + i);

            service.create(user);
        }

        /*
            * Create Employee1
         */
//        Employee employee1 = new Employee();
//        employee1.setName("Han Yenn");
//        employee1.setJoiningDate(new LocalDate(2010, 10, 10));
//        employee1.setSalary(new BigDecimal(10000));
//        employee1.setSsn("ssn00000001");
/*
* Create Employee2
         */
//        Employee employee2 = new Employee();
//        employee2.setName("Dan Thomas");
//        employee2.setJoiningDate(new LocalDate(2012, 11, 11));
//        employee2.setSalary(new BigDecimal(20000));
//        employee2.setSsn("ssn00000002");

        /*
* Persist both Employees
         */
//        service.saveEmployee(employee1);
//        service.saveEmployee(employee2);

        /*
* Get all employees list from database
         */
        List<Categorie> cs = service.findAll();
        for (Categorie emp : cs) {
            System.out.println(emp);
        }
        long count = 0;
        Categorie user5 = null;
        for (Categorie user : cs) {
            count++;
            if (count == 5) {
                System.out.println(" count " + count);
                user5 = service.findByID(count);
            }
            user.setCategorie("Yzssine ");
        
            service.edit(user);
            System.out.println(" user Edit " + user);
        }

        System.out.println("user5 findByID " + user5);
        /*
             * delete an employee
         */
//        service.deleteEmployeeBySsn("ssn00000002");
//
//        /*
//         * update an employee
//         */
//        Employee employee = service.findBySsn("ssn00000001");
//        employee.setSalary(new BigDecimal(50000));
//        service.updateEmployee(employee);
//
//        /*
//         * Get all employees list from database
//         */
//        List<Employee> employeeList = service.findAllEmployees();
//        for (Employee emp : employeeList) {
//            System.out.println(emp);
//        }
    }

}
