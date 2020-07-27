package com.dev.wellness.repositories;

import com.dev.wellness.models.entities.AppointmentType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentTypeRepository extends JpaRepository<AppointmentType, Integer> {
}
