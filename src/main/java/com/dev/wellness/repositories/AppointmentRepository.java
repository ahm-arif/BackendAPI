package com.dev.wellness.repositories;

import com.dev.wellness.models.entities.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

}
