package com.dev.wellness.services.impl;

import com.dev.wellness.exception.NotFoundException;
import com.dev.wellness.models.entities.DoctorCategory;
import com.dev.wellness.repositories.DoctorCategoryRepository;
import com.dev.wellness.services.api.DoctorCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorCategoryServiceImpl implements DoctorCategoryService {

  @Autowired
  private DoctorCategoryRepository repository;

  @Override
  public DoctorCategory findOne(int id) {
    return repository.findById(id).orElseThrow(() -> new NotFoundException("Doctor category not found"));
  }

}
