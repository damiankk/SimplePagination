package com.restprojects.employee;

import com.restprojects.services.EmployeeService;
import com.restprojects.services.PaginationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;

import java.util.List;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Employee> getEmployees() {
        return employeeService.findAllEmployees();
    }

    @GetMapping(value = "/page", produces = MediaType.APPLICATION_JSON_VALUE)
    public Page<Employee> getPage(Pageable pageable){
        return employeeService.listAllByPage(pageable);
    }

   @GetMapping(value = "/pagePage/{val}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<?> getEmployeesPage(@PathVariable("val") Integer val){
       return employeeService.listAllByPage(val);
   }

}
