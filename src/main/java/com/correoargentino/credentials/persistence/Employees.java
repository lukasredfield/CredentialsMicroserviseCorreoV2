package com.correoargentino.credentials.persistence;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "employees")
public class Employees {

    @Id
    @Column(name = "dni")
    private Long dni;

    @Column(name = "name")
    private String name;

    @Column(name = "last_name")
    private String lastName;

}