package com.dev.wellness.controllers;

import com.dev.wellness.models.entities.Complaint;
import com.dev.wellness.models.inbounds.ComplaintInbound;
import com.dev.wellness.models.outbounds.wrapper.BaseResponse;
import com.dev.wellness.models.outbounds.wrapper.DataResponse;
import com.dev.wellness.models.outbounds.wrapper.PageDataResponse;
import com.dev.wellness.models.outbounds.wrapper.Paging;
import com.dev.wellness.services.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/complaints")
public class ComplaintController {

  private final ComplaintService complaintService;

  public ComplaintController(ComplaintService complaintService) {
    this.complaintService = complaintService;
  }

  @GetMapping
  public PageDataResponse<Complaint> getAllComplaint(
          @RequestParam(required = false,
                  defaultValue = "0")
                  int page,
          @RequestParam(required = false,
                  defaultValue = "10")
                  int size
  ) {
    Page<Complaint> complaints = complaintService.findAll(page, size);
    Paging paging = Paging.builder()
            .page(complaints.getPageable().getPageNumber())
            .size(complaints.getSize())
            .totalRecords(complaints.getTotalElements())
            .build();

    return PageDataResponse.<Complaint>dataBuilder()
            .code(200)
            .status("Success")
            .paging(paging)
            .data(complaints.get().collect(Collectors.toList()))
            .build();
  }

  @PostMapping
  public DataResponse<Complaint> createComplaint(
          @RequestBody ComplaintInbound complaintInbound
  ) {
    Complaint complaint = complaintService.create(complaintInbound);
    return DataResponse.<Complaint>dataBuilder()
            .code(200)
            .status("Success")
            .data(complaint)
            .build();
  }

  @DeleteMapping(value = "/{complaintId}")
  public BaseResponse deleteComplaint(
          @PathVariable int complaintId
  ) {
    complaintService.delete(complaintId);
    return BaseResponse.builder()
            .code(200)
            .status("Success")
            .build();
  }

  @PutMapping(value = "/{complaintId}")
  public DataResponse<Complaint> updateComplaint(
          @PathVariable int complaintId,
          @RequestBody ComplaintInbound complaintInbound
  ) {
    Complaint complaint = complaintService.update(complaintId, complaintInbound);
    return DataResponse.<Complaint>dataBuilder()
            .code(200)
            .status("Success")
            .data(complaint)
            .build();
  }

}
