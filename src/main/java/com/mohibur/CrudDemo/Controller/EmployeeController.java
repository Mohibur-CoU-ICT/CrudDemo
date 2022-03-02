package com.mohibur.CrudDemo.Controller;

import com.mohibur.CrudDemo.Entity.Employee;
import com.mohibur.CrudDemo.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping(value = "")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping(value = "/{id}")
    public Employee getEmployeeById(@PathVariable(value = "id") long id) {
        return employeeService.getEmployeeById(id);
    }

    @PostMapping(value = "/create")
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

    @PostMapping(value = "/create/many")
    public List<Employee> createEmployees(@RequestBody List<Employee> employees) {
        return employeeService.createEmployees(employees);
    }

    @PutMapping(value = "/update/{id}")
    public Employee updateEmployee(@PathVariable(value = "id") long id, @RequestBody Employee employee) {
        Employee updatedEmployee = employeeService.getEmployeeById(id);
        if(employee.getName() != null) updatedEmployee.setName(employee.getName());
        if(employee.getDepartment() != null) updatedEmployee.setDepartment(employee.getDepartment());
        if(employee.getAddress() != null) updatedEmployee.setAddress(employee.getAddress());
        if(employee.getSalary() != 0L) updatedEmployee.setSalary(employee.getSalary());
        if(employee.getDateOfBirth() != null) updatedEmployee.setDateOfBirth(employee.getDateOfBirth());
        return employeeService.createEmployee(updatedEmployee);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteEmployee(@PathVariable(value = "id") long id) {
        employeeService.deleteEmployee(id);
    }

    @DeleteMapping(value = "/delete/all")
    public void deleteAllEmployees() {
        employeeService.deleteAllEmployees();
    }

    @GetMapping(value = "/sorted")
    public Page<Employee> getEmployeesSorted(
            @RequestParam("page") Optional<Integer> page,
            @RequestParam("size") Optional<Integer> size,
            @RequestParam("sortDir") Optional<String> sortDirection,
            @RequestParam("sortBy") Optional<String> sortBy){
        return employeeService.getEmployeesSorted(page, size, sortDirection, sortBy);
    }

    @GetMapping(value = "/sorted/pagewise")
    public List<Employee> getEmployeesPageWiseSorted(
            @RequestParam("page") Optional<Integer> page,
            @RequestParam("size") Optional<Integer> size,
            @RequestParam("sortDir") Optional<String> sortDirection,
            @RequestParam("sortBy") Optional<String> sortBy){
        return employeeService.getEmployeesPageWiseSorted(page, size, sortDirection, sortBy);
    }

}
