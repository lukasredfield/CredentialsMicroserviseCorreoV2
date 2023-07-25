package com.correoargentino.credentials.service;
import com.correoargentino.credentials.persistence.Employees;
import java.util.Optional;

public interface EmployeeService {
    Optional<Employees> getEmployeeByDni(Long dni);
}