package org.example;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.Map;

public class Tester11 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext path=new ClassPathXmlApplicationContext("Xmlfile.xml");
        Employee emp=(Employee) path.getBean("pro1");
        Employee emp1=(Employee) path.getBean("pro2");
        EmployeeServiceImpl employeeService= (EmployeeServiceImpl) path.getBean("empService");
        employeeService.service(emp);
        employeeService.service(emp1);
        System.out.println(employeeService.get());

    }
}
