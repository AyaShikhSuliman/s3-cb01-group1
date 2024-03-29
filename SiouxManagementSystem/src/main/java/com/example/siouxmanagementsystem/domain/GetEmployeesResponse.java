package com.example.siouxmanagementsystem.domain;

import com.example.siouxmanagementsystem.persistence.entity.EmployeeEntity;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class GetEmployeesResponse {
    private List<EmployeeEntity> employees;
}
