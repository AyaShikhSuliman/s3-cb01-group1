package com.example.siouxmanagementsystem.configuration.db;

import com.example.siouxmanagementsystem.persistence.AppointmentRepository;
import com.example.siouxmanagementsystem.persistence.DepartmentRepository;
import com.example.siouxmanagementsystem.persistence.EmployeeRepository;
import com.example.siouxmanagementsystem.persistence.GuestRepository;
import com.example.siouxmanagementsystem.persistence.entity.AppointmentEntity;
import com.example.siouxmanagementsystem.persistence.entity.DepartmentEntity;
import com.example.siouxmanagementsystem.persistence.entity.EmployeeEntity;
import com.example.siouxmanagementsystem.persistence.entity.GuestEntity;
import lombok.AllArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Component
@AllArgsConstructor
public class DatabaseInitializer {
    private DepartmentRepository departmentRepository;
    private EmployeeRepository employeeRepository;
    private AppointmentRepository appointmentRepository;
    private GuestRepository guestRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void populateDatabaseInitialDummyData() {
        if (departmentRepository.count() == 0) {
            departmentRepository.save(DepartmentEntity.builder().name("IT").build());
            departmentRepository.save(DepartmentEntity.builder().name("Finance").build());
        }

        if (employeeRepository.count() == 0) {
            employeeRepository.save(EmployeeEntity.builder()
                    .name("Aya")
                    .emailAddress("aya@gmail.com")
                    .department(DepartmentEntity.builder().id(1L).build())
                    .build());
            employeeRepository.save(EmployeeEntity.builder()
                    .name("Alaa")
                    .emailAddress("alaa@gmail.com")
                    .department(DepartmentEntity.builder().id(2L).build())
                    .build());
            employeeRepository.save(EmployeeEntity.builder()
                    .name("Rob")
                    .emailAddress("rob@gmail.com")
                    .department(DepartmentEntity.builder().id(2L).build())
                    .build());
            employeeRepository.save(EmployeeEntity.builder()
                    .name("Fabienne")
                    .emailAddress("fabienne@gmail.com")
                    .department(DepartmentEntity.builder().id(1L).build())
                    .build());
        }
        if (guestRepository.count() == 0) {
            guestRepository.save(
                    GuestEntity.builder()
                            .name("guest John")
                            .email_address("guest1@gmail.com")
                            .license("ABC123")
                            .build()
            );
            guestRepository.save(
                    GuestEntity.builder()
                            .name("guest Mike")
                            .email_address("guest2@gmail.com")
                            .license("ABC213")
                            .build()
            );
            guestRepository.save(
                    GuestEntity.builder()
                            .name("guest Jos")
                            .email_address("guest3@gmail.com")
                            .license("ABC321")
                            .build()
            );
            guestRepository.save(
                    GuestEntity.builder()
                            .name("guest Marielle")
                            .email_address("guest4@gmail.com")
                            .license("ACB312")
                            .build()
            );
        }
        if (appointmentRepository.count() == 0) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm");
            appointmentRepository.save(
                    AppointmentEntity.builder()
                            .start_time(LocalTime.of(02, 00, 00).format(formatter))
                            .end_time(LocalTime.of(02, 00, 00).format(formatter))
                            .date(LocalDate.of(2023, 04, 01))
                            .employee(employeeRepository.findById(1L).get())
                            .guest(guestRepository.findGuestEntityByLicense("ABC123").get())
                            .build()
            );
            appointmentRepository.save(
                    AppointmentEntity.builder()
                            .start_time(LocalTime.of(12, 30, 00).format(formatter))
                            .end_time(LocalTime.of(01, 30, 00).format(formatter))
                            .date(LocalDate.of(2023, 04, 02))
                            .employee(employeeRepository.findById(1L).get())
                            .guest(guestRepository.findGuestEntityByLicense("ACB312").get())
                            .build()
            );
            appointmentRepository.save(
                    AppointmentEntity.builder()
                            .start_time(LocalTime.of(10, 00, 00).format(formatter))
                            .end_time(LocalTime.of(11, 00, 00).format(formatter))
                            .date(LocalDate.of(2023, 04, 05))
                            .employee(employeeRepository.findById(2L).get())
                            .guest(guestRepository.findGuestEntityByLicense("ABC321").get())
                            .build()
            );
            appointmentRepository.save(
                    AppointmentEntity.builder()
                            .start_time(LocalTime.of(12, 30, 00).format(formatter))
                            .end_time(LocalTime.of(01, 00, 00).format(formatter))
                            .date(LocalDate.of(2023, 04, 05))
                            .employee(employeeRepository.findById(3L).get())
                            .guest(guestRepository.findGuestEntityByLicense("ABC213").get())
                            .build()
            );
            appointmentRepository.save(
                    AppointmentEntity.builder()
                            .start_time(LocalTime.of(11, 30, 00).format(formatter))
                            .end_time(LocalTime.of(12, 00, 00).format(formatter))
                            .date(LocalDate.of(2023, 04, 06))
                            .employee(employeeRepository.findById(4L).get())
                            .guest(guestRepository.findGuestEntityByLicense("ACB312").get())
                            .build()
            );
            appointmentRepository.save(
                    AppointmentEntity.builder()
                            .start_time(LocalTime.of(11, 30, 00).format(formatter))
                            .end_time(LocalTime.of(12, 00, 00).format(formatter))
                            .date(LocalDate.of(2023, 05, 06))
                            .employee(employeeRepository.findById(4L).get())
                            .guest(guestRepository.findGuestEntityByLicense("ACB312").get())
                            .build()
            );
            appointmentRepository.save(
                    AppointmentEntity.builder()
                            .start_time(LocalTime.of(11, 30, 00).format(formatter))
                            .end_time(LocalTime.of(12, 00, 00).format(formatter))
                            .date(LocalDate.of(2023, 05, 07))
                            .employee(employeeRepository.findById(4L).get())
                            .guest(guestRepository.findGuestEntityByLicense("ACB312").get())
                            .build()
            );
            appointmentRepository.save(
                    AppointmentEntity.builder()
                            .start_time(LocalTime.of(11, 30, 00).format(formatter))
                            .end_time(LocalTime.of(12, 00, 00).format(formatter))
                            .date(LocalDate.of(2023, 05, 07))
                            .employee(employeeRepository.findById(4L).get())
                            .guest(guestRepository.findGuestEntityByLicense("ACB312").get())
                            .build()
            );
            appointmentRepository.save(
                    AppointmentEntity.builder()
                            .start_time(LocalTime.of(11, 30, 00).format(formatter))
                            .end_time(LocalTime.of(12, 00, 00).format(formatter))
                            .date(LocalDate.of(2023, 05, 9))
                            .employee(employeeRepository.findById(4L).get())
                            .guest(guestRepository.findGuestEntityByLicense("ACB312").get())
                            .build()
            );
            appointmentRepository.save(
                    AppointmentEntity.builder()
                            .start_time(LocalTime.of(11, 30, 00).format(formatter))
                            .end_time(LocalTime.of(12, 00, 00).format(formatter))
                            .date(LocalDate.of(2023, 05, 10))
                            .employee(employeeRepository.findById(3L).get())
                            .guest(guestRepository.findGuestEntityByLicense("ACB312").get())
                            .build()
            );
            appointmentRepository.save(
                    AppointmentEntity.builder()
                            .start_time(LocalTime.of(11, 30, 00).format(formatter))
                            .end_time(LocalTime.of(12, 00, 00).format(formatter))
                            .date(LocalDate.of(2023, 05, 12))
                            .employee(employeeRepository.findById(2L).get())
                            .guest(guestRepository.findGuestEntityByLicense("ACB312").get())
                            .build()
            );
            appointmentRepository.save(
                    AppointmentEntity.builder()
                            .start_time(LocalTime.of(11, 30, 00).format(formatter))
                            .end_time(LocalTime.of(12, 00, 00).format(formatter))
                            .date(LocalDate.of(2023, 05, 16))
                            .employee(employeeRepository.findById(1L).get())
                            .guest(guestRepository.findGuestEntityByLicense("ACB312").get())
                            .build()
            );
            appointmentRepository.save(
                    AppointmentEntity.builder()
                            .start_time(LocalTime.of(11, 30, 00).format(formatter))
                            .end_time(LocalTime.of(12, 00, 00).format(formatter))
                            .date(LocalDate.of(2023, 05, 18))
                            .employee(employeeRepository.findById(2L).get())
                            .guest(guestRepository.findGuestEntityByLicense("ACB312").get())
                            .build()
            );
            appointmentRepository.save(
                    AppointmentEntity.builder()
                            .start_time(LocalTime.of(11, 30, 00).format(formatter))
                            .end_time(LocalTime.of(12, 00, 00).format(formatter))
                            .date(LocalDate.of(2023, 06, 20))
                            .employee(employeeRepository.findById(2L).get())
                            .guest(guestRepository.findGuestEntityByLicense("ACB312").get())
                            .build()
            );
            appointmentRepository.save(
                    AppointmentEntity.builder()
                            .start_time(LocalTime.of(11, 30, 00).format(formatter))
                            .end_time(LocalTime.of(12, 00, 00).format(formatter))
                            .date(LocalDate.of(2023, 06, 22))
                            .employee(employeeRepository.findById(2L).get())
                            .guest(guestRepository.findGuestEntityByLicense("ACB312").get())
                            .build()
            );
            appointmentRepository.save(
                    AppointmentEntity.builder()
                            .start_time(LocalTime.of(11, 30, 00).format(formatter))
                            .end_time(LocalTime.of(12, 00, 00).format(formatter))
                            .date(LocalDate.of(2023, 06, 22))
                            .employee(employeeRepository.findById(2L).get())
                            .guest(guestRepository.findGuestEntityByLicense("ACB312").get())
                            .build()
            );
        }
    }
}
