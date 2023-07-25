package com.correoargentino.credentials.controllers;


import com.correoargentino.credentials.persistence.Employees;
import com.correoargentino.credentials.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/employees")
public class EmployeesController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeesController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/found")
    public RedirectView redirectToemployees(@RequestParam("dni") Long dni) {
        return new RedirectView("/employees.html?dni=" + dni);
    }


    @GetMapping("/not_found")
    public RedirectView redirectTorejected() {
        return new RedirectView("/rejected.html");
    }

    @GetMapping("/{dni}")
    public ResponseEntity<Employees> getEmployeeByDni(@PathVariable("dni") Long dni) {
        return employeeService.getEmployeeByDni(dni)
                .map(employee -> ResponseEntity.ok().body(employee))
                .orElse(ResponseEntity.notFound().build());
    }

}