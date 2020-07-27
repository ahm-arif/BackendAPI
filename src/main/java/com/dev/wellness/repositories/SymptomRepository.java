package com.dev.wellness.repositories;

import com.dev.wellness.models.entities.Symptom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SymptomRepository extends JpaRepository<Symptom, Integer> {
}
