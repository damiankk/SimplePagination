package com.restprojects.services;

import com.restprojects.employee.Employee;
import com.restprojects.employee.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmployeeService{

    private final EmployeeRepository employeeRepository;


    @Autowired
    public EmployeeService(final EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public String save(Employee employee){
        employeeRepository.save(employee);
        return employee.getId();
    }

    public void delete(Employee employee){
        employeeRepository.delete(employee);
    }

    public Employee findById(String id) {
        return employeeRepository.findOne(id);
    }

    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    public Page<Employee> listAllByPage(Pageable pageable){
        return employeeRepository.findAll(pageable);
    }


    public List<Object> listAllByPage(Integer page){
        return PaginationService.listAllByPage(page,employeeRepository);
    }


}
