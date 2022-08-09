package com.example.demo.model;

import lombok.*;

import javax.validation.constraints.NotEmpty;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class EmployeeModel {
    @NotEmpty(message = "must be required")
    private Long employeeId;
    private String employeeName;
    private String employeeCity;
}
