package com.correoargentino.credentials.service;


import com.correoargentino.credentials.persistence.Employees;

import com.correoargentino.credentials.repository.EmployeesRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServiceImp implements EmployeeService{

    private final EmployeesRepository employeesRepository;

    public EmployeeServiceImp(EmployeesRepository employeesRepository) {
        this.employeesRepository = employeesRepository;
    }

    @Override
    public Optional<Employees> getEmployeeByDni(Long dni) {
        return employeesRepository.findById(dni);
    }
}