package com.dev.wellness.services.api;

import com.dev.wellness.models.entities.AppointmentType;

public interface AppointmentTypeService {
  AppointmentType findById(int id);
}
