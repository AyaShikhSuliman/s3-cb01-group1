package com.example.siouxmanagementsystem.business.UseCases.EmployeeUseCases;

import com.example.siouxmanagementsystem.domain.GetEmployeesResponse;

public interface GetEmployeesUseCase {

    GetEmployeesResponse getEmployeeEntitiesByDepartmentName(String depName);

    GetEmployeesResponse findEmployeeEntityByName(String name);
}
