package com.dev.wellness.services.api;

import com.dev.wellness.models.entities.Doctor;
import com.dev.wellness.models.inbounds.DoctorInbound;
import org.springframework.data.domain.Page;

public interface DoctorService {
  Page<Doctor> searchDoctorByName(String name, int page, int limit);
  Doctor findById(int id);
  Doctor createDoctor(DoctorInbound doctorInbound);
  void deleteDoctor(int id);
  Doctor updateDoctor(int id, DoctorInbound doctorInbound);
}
