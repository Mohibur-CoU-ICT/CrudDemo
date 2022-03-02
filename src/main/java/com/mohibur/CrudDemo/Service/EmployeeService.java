package com.mohibur.CrudDemo.Service;

import com.mohibur.CrudDemo.Entity.Employee;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    Employee getEmployeeById(long id);
    List<Employee> getAllEmployees();
    Page<Employee> getEmployeesSorted(
            Optional<Integer>page,
            Optional<Integer>size,
            Optional<String>sortDirection,
            Optional<String>sortBy);
    List<Employee> getEmployeesPageWiseSorted(
            Optional<Integer>page,
            Optional<Integer>size,
            Optional<String>sortDirection,
            Optional<String>sortBy);
    Employee createEmployee(Employee employee);
    List<Employee> createEmployees(List<Employee> employees);
    void deleteEmployee(long id);
    void deleteAllEmployees();
}
