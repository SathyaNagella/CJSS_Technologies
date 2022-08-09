package org.example;

import java.util.HashMap;
import java.util.Map;

public class EmployeeServiceImpl implements EmployeeService{

    Map<Integer,Employee> map=new HashMap<>();
    @Override
    public void service(Employee employee)
    {
        map.put(employee.getId(),employee);
    }

    @Override
    public Map<Integer, Employee> get() {
        return map;
    }
}
