package com.dev.wellness.services;

import com.dev.wellness.models.entities.Complaint;
import com.dev.wellness.models.inbounds.ComplaintInbound;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface ComplaintService {

  Page<Complaint> findAll(int page, int limit);
  Optional<Complaint> findOne(int id);
  void delete(int id);
  Complaint create(ComplaintInbound complaint);
  Complaint update(int id, ComplaintInbound complaint);

}
