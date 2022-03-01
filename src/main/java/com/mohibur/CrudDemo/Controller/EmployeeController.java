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

    @PutMapping(value = "/update/{id}")
    public Employee updateEmployee(@PathVariable(value = "id") long id, @RequestBody Employee employee) {
        Employee employee1 = employeeService.getEmployeeById(id);
        employee1.setName(employee.getName());
        employee1.setDepartment(employee.getDepartment());
        employee1.setAddress(employee.getAddress());
        employee1.setSalary(employee.getSalary());
        employee1.setDateOfBirth(employee.getDateOfBirth());
        return employeeService.createEmployee(employee1);
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
