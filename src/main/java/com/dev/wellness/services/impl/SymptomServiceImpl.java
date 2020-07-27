package com.dev.wellness.services.impl;

import com.dev.wellness.exception.NotFoundException;
import com.dev.wellness.models.entities.Symptom;
import com.dev.wellness.repositories.SymptomRepository;
import com.dev.wellness.services.api.SymptomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SymptomServiceImpl implements SymptomService {

  @Autowired
  private SymptomRepository repository;

  @Override
  public Symptom findById(int id) {
    return repository.findById(id).orElseThrow(() -> new NotFoundException("Symptom not found"));
  }
}
