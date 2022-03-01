package com.mohibur.CrudDemo.Service;

import com.mohibur.CrudDemo.Entity.Employee;
import com.mohibur.CrudDemo.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee getEmployeeById(long id) {
        Optional<Employee> optional = employeeRepository.findById(id);
        Employee employee;
        if(optional.isPresent()) {
            employee = optional.get();
        } else {
            throw new RuntimeException("Employee not found for id = " + id);
        }
        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Page<Employee> getEmployeesSorted(
            Optional<Integer> page,
            Optional<Integer> size,
            Optional<String> sortDirection,
            Optional<String> sortBy) {
        System.out.println("getEmployeesSorted called");
        System.out.println("page = " + page.orElse(0) + ", size = " + size.orElse(10) + ", offset = " +
                page.orElse(0) * size.orElse(10) + ", sortDirection = " + sortDirection.orElse("ASC") + ", sortBy = " + sortBy.orElse("id"));
        return employeeRepository.findAll(
                PageRequest.of(
                        page.orElse(0),
                        size.orElse(10),
                        Sort.Direction.valueOf(sortDirection.orElse("ASC")),
                        sortBy.orElse("id")
                )
        );
    }

    @Override
    public List<Employee> getEmployeesPageWiseSorted(
            Optional<Integer> page,
            Optional<Integer> size,
            Optional<String> sortDirection,
            Optional<String> sortBy) {
        System.out.println("getEmployeesPageWiseSorted called");
        System.out.println("page = " + page.orElse(0) + ", size = " + size.orElse(10) + ", offset = " +
                page.orElse(0) * size.orElse(10) + ", sortDirection = " + sortDirection.orElse("ASC") + ", sortBy = " + sortBy.orElse("id"));
        return employeeRepository.getEmployeesPageWiseSorted(
                size.orElse(10),
                page.orElse(0) * size.orElse(10),
                String.valueOf(Sort.Direction.valueOf(sortDirection.orElse("ASC"))),
                sortBy.orElse("id")
        );
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public void deleteAllEmployees() {
        employeeRepository.deleteAll();
    }
}
