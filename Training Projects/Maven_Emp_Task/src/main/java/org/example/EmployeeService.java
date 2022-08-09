package org.example;

import java.util.Map;

public interface EmployeeService {
     void service(Employee employee);
     Map<Integer,Employee> get();
}
