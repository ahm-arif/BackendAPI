package com.dev.wellness.services.api;

import com.dev.wellness.models.entities.DoctorCategory;

public interface DoctorCategoryService {
  DoctorCategory findOne(int id);
}
