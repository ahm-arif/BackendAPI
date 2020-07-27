package com.dev.wellness.services.impl;

import com.dev.wellness.exception.NotFoundException;
import com.dev.wellness.models.entities.AppointmentType;
import com.dev.wellness.repositories.AppointmentTypeRepository;
import com.dev.wellness.services.api.AppointmentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentTypeServiceImpl implements AppointmentTypeService {

  @Autowired
  private AppointmentTypeRepository repository;

  @Override
  public AppointmentType findById(int id) {
    return repository.findById(id).orElseThrow(() -> new NotFoundException("Appointment type not found"));
  }
}
