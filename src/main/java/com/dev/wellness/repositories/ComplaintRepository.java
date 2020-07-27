package com.dev.wellness.repositories;

import com.dev.wellness.models.entities.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ComplaintRepository extends JpaRepository<Complaint, Integer> {

}
