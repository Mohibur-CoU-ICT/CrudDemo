package com.mohibur.CrudDemo.Service;

import com.mohibur.CrudDemo.Entity.Employee;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    Employee getEmployeeById(long id);
    List<Employee> getAllEmployees();
    Employee createEmployee(Employee employee);
    void deleteEmployee(long id);
    void deleteAllEmployees();
}
