package com.dev.wellness.services.api;

import com.dev.wellness.models.entities.Appointment;
import com.dev.wellness.models.inbounds.AppointmentInbound;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface AppointmentService {

  Page<Appointment> findAll(int page, int limit);
  Appointment findOne(int id);
  void delete(int id);
  Appointment create(AppointmentInbound complaint);
  Appointment update(int id, AppointmentInbound complaint);

}
