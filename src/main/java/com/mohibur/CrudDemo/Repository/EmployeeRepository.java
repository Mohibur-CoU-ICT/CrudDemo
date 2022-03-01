package com.mohibur.CrudDemo.Repository;

import com.mohibur.CrudDemo.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query(value = "SELECT * FROM (SELECT * FROM employee LIMIT :size OFFSET :offset) res ORDER BY :sortBy :sortDir", nativeQuery = true)
    List<Employee> getEmployeesPageWiseSorted(
            @Param("size") int size,
            @Param("offset") int offset,
            @Param("sortDir") String sortDir,
            @Param("sortBy") String sortBy);
}
