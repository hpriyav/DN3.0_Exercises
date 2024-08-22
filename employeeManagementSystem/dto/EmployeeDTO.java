package com.example.employeemanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class EmployeeDTO {
    private Long id;
    private String name;
    private String email;
}
