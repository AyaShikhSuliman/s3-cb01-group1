package com.example.siouxmanagementsystem.business.impl;

import com.example.siouxmanagementsystem.business.UseCases.LicensePlateUseCase;
import com.example.siouxmanagementsystem.persistence.AppointmentRepository;
import com.example.siouxmanagementsystem.persistence.entity.AppointmentEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Optional;

@Service
@AllArgsConstructor
public class LicensePlateUseCaseImpl implements LicensePlateUseCase {
    private final AppointmentRepository appointmentRepository;
    private final SendEmailUseCaseImpl emailCreationUseCase;

    @Transactional
    @Override
    public String compareLicense(String request) {
        LocalDate date = LocalDate.of(2023, 4, 5); //TODO: should be date of today

        //find appointment/guest by license and date
        Optional<AppointmentEntity> appointment = Optional.ofNullable(appointmentRepository.getAppointmentByLicenseAndDate(request, date));

        if (appointment.isEmpty()) {
            return "no matching license found";
        }

        //if found -> notify employee and secretary
        System.out.println(appointment.get().getEmployee().getName());
        //TODO: before notifying, check with sensors if there's an available parking spot for the guest
        //checkAvailability

        notifyEmployee(appointment.get().getEmployee().getEmailAddress(), appointment.get().getGuest().getName());

        return "found matching license";
    }

    //notifies employee and secretary
    public void notifyEmployee(String employeeEmail, String guestName) {
        //notify by secretary and employee via email
        //TODO: before sending email, check with sensor if guest can find a parking spot, change the body accordingly
        emailCreationUseCase.createEmail(employeeEmail, guestName + " has almost arrived");
    }

    public boolean checkAvailabilty() {
        //TODO: check with sensors if there's an available spot and notify guest if not
        return false;
    }
}
