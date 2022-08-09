package org.example;

import java.util.Map;

public class Tester {
    public static void main(String[] args) {
        EmployeeServiceImpl service=new EmployeeServiceImpl();
               service.service(new Employee(100,"Abhi","Ram","SD"));
               service.service(new Employee(104,"A","X","role1"));
                service.service(new Employee(102,"A","X","role1"));
                service.service(new Employee(103,"A","X","role1"));

        Map<Integer,Employee> data=service.get();
        System.out.println(data);
    }
}
