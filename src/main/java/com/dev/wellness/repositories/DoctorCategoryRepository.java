package com.dev.wellness.repositories;

import com.dev.wellness.models.entities.DoctorCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorCategoryRepository extends JpaRepository<DoctorCategory, Integer> {
}
