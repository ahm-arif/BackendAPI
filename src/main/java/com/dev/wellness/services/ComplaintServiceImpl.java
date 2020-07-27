package com.dev.wellness.services;

import com.dev.wellness.models.entities.Complaint;
import com.dev.wellness.models.inbounds.ComplaintInbound;
import com.dev.wellness.repositories.ComplaintRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ComplaintServiceImpl implements ComplaintService {

  private final ComplaintRepository complaintRepository;

  public ComplaintServiceImpl(ComplaintRepository complaintRepository) {
    this.complaintRepository = complaintRepository;
  }

  @Override
  public Page<Complaint> findAll(int page, int limit) {
    return complaintRepository.findAll(PageRequest.of(page, limit));
  }

  @Override
  public Optional<Complaint> findOne(int id) {
    return complaintRepository.findById(id);
  }

  @Override
  public void delete(int id) {
    complaintRepository.deleteById(id);
  }

  @Override
  public Complaint create(ComplaintInbound complaint) {
    return complaintRepository.save(Complaint.builder()
            .description(complaint.getDescription())
            .name(complaint.getName())
            .build());
  }

  @Override
  public Complaint update(int id, ComplaintInbound complaint) {
    Complaint existingComplaint = Optional.of(id)
            .map(complaintRepository::findById)
            .map(c -> c.orElse(Complaint.builder().build()))
            .orElse(Complaint.builder().build());

    existingComplaint.setName(complaint.getName());
    existingComplaint.setDescription(complaint.getDescription());

    return complaintRepository.save(existingComplaint);
  }
}
