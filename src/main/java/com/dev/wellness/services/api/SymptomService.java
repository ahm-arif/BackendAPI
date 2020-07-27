package com.dev.wellness.services.api;

import com.dev.wellness.models.entities.Symptom;

public interface SymptomService {
  Symptom findById(int id);
}
