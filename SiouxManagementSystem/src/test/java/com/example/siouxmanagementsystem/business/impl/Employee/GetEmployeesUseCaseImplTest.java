package com.example.siouxmanagementsystem.business.impl.Employee;

import com.example.siouxmanagementsystem.business.UseCases.EmployeeUseCases.GetEmployeesUseCase;
import com.example.siouxmanagementsystem.business.impl.Appointment.AppointmentConverter;
import com.example.siouxmanagementsystem.business.impl.Appointment.GetAppointmentsUseCaseImpl;
import com.example.siouxmanagementsystem.business.impl.Employee.EmployeeConverter;
import com.example.siouxmanagementsystem.business.impl.Employee.GetEmployeesUseCaseImpl;
import com.example.siouxmanagementsystem.domain.Appointment.GetAppointmentsResponse;
import com.example.siouxmanagementsystem.domain.GetEmployeesResponse;
import com.example.siouxmanagementsystem.persistence.AppointmentRepository;
import com.example.siouxmanagementsystem.persistence.EmployeeRepository;
import com.example.siouxmanagementsystem.persistence.entity.AppointmentEntity;
import com.example.siouxmanagementsystem.persistence.entity.DepartmentEntity;
import com.example.siouxmanagementsystem.persistence.entity.EmployeeEntity;
import com.example.siouxmanagementsystem.persistence.entity.GuestEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetEmployeesUseCaseImplTest {

    @Mock
    private EmployeeRepository employeeRepositoryMock;

    @InjectMocks
    private GetEmployeesUseCaseImpl getEmployeesUseCase;

    @Test
    void getEmployeesByDepName() {
        EmployeeEntity employee = getEmployee();

        when(employeeRepositoryMock.getEmployeeEntitiesByDepartment_Name("IT")).thenReturn(List.of(employee));

        GetEmployeesResponse actualResponse = getEmployeesUseCase.getEmployeeEntitiesByDepartmentName("IT");

        GetEmployeesResponse expectedResponse = GetEmployeesResponse.builder()
                .employees(List.of(employee).stream().map(EmployeeConverter::convert).toList())
                .build();

        assertEquals(actualResponse, expectedResponse);
    }

    @Test
    void findEmployeeEntityByName() {
        EmployeeEntity employee = EmployeeEntity.builder()
                .id(1L)
                .name("test")
                .emailAddress("test@gmail.com")
                .build();

        when(employeeRepositoryMock.findEmployeeEntityByNameContainingIgnoreCase("est")).thenReturn(List.of(employee));

        GetEmployeesResponse actualResponse = getEmployeesUseCase.findEmployeeEntityByName("est");

        GetEmployeesResponse expectedResponse = GetEmployeesResponse.builder()
                .employees(List.of(employee).stream().map(EmployeeConverter::convert).toList())
                .build();

        assertEquals(actualResponse, expectedResponse);
    }

    private EmployeeEntity getEmployee()
    {
        DepartmentEntity department = DepartmentEntity.builder()
                .id(1L)
                .name("IT")
                .build();

        EmployeeEntity employee  = EmployeeEntity.builder()
                .id(1L)
                .name("test")
                .emailAddress("test@gmail.com")
                .department(department)
                .build();

        return employee;
    }
}