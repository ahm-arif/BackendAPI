package com.dev.wellness.controllers;

import com.dev.wellness.models.entities.Doctor;
import com.dev.wellness.models.inbounds.DoctorInbound;
import com.dev.wellness.models.outbounds.DoctorDetailOutbound;
import com.dev.wellness.models.outbounds.DoctorOutbound;
import com.dev.wellness.models.outbounds.wrapper.BaseResponse;
import com.dev.wellness.models.outbounds.wrapper.DataResponse;
import com.dev.wellness.models.outbounds.wrapper.PageDataResponse;
import com.dev.wellness.models.outbounds.wrapper.Paging;
import com.dev.wellness.services.api.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/doctors")
public class DoctorController {

  @Autowired
  private DoctorService doctorService;

  @GetMapping
  public PageDataResponse<DoctorOutbound> searchDoctor(
          @RequestParam(required = false, defaultValue = "0")
          int page,
          @RequestParam(required = false, defaultValue = "10")
          int size,
          @RequestParam(required = false, defaultValue = "")
          String name
  ) {
    Page<Doctor> doctors = doctorService.searchDoctorByName(name, page, size);
    Paging paging = Paging.builder()
            .totalRecords(doctors.getTotalElements())
            .page(doctors.getPageable().getPageNumber())
            .size(doctors.getSize())
            .build();

    return PageDataResponse.<DoctorOutbound>dataBuilder()
            .code(HttpStatus.OK.value())
            .status(HttpStatus.OK.getReasonPhrase())
            .paging(paging)
            .data(
                    doctors.getContent()
                            .stream()
                            .map(DoctorOutbound::of)
                            .collect(Collectors.toList()))
            .build();
  }

  @GetMapping(value = "/{doctorId}")
  public DataResponse<DoctorDetailOutbound> getDoctorDetail(@PathVariable int doctorId) {
    return DataResponse.<DoctorDetailOutbound>dataBuilder()
            .data(DoctorDetailOutbound.of(doctorService.findById(doctorId)))
            .code(HttpStatus.OK.value())
            .status(HttpStatus.OK.getReasonPhrase())
            .build();
  }

  @PostMapping
  public DataResponse<DoctorDetailOutbound> createDoctor(
          @RequestBody
          DoctorInbound doctorInbound
  ) {
    return DataResponse.<DoctorDetailOutbound>dataBuilder()
            .data(DoctorDetailOutbound.of(doctorService.createDoctor(doctorInbound)))
            .status(HttpStatus.OK.getReasonPhrase())
            .code(HttpStatus.OK.value())
            .build();
  }

  @DeleteMapping(value = "/{doctorId}")
  public BaseResponse deleteDoctor(@PathVariable int doctorId) {
    doctorService.deleteDoctor(doctorId);
    return BaseResponse.builder()
            .code(HttpStatus.OK.value())
            .status(HttpStatus.OK.getReasonPhrase())
            .build();
  }

  @PutMapping(value = "/{doctorId}")
  public DataResponse<DoctorDetailOutbound> updateDoctor(
          @PathVariable int doctorId,
          @RequestBody DoctorInbound doctorInbound
  ) {
    return DataResponse.<DoctorDetailOutbound>dataBuilder()
            .code(HttpStatus.OK.value())
            .status(HttpStatus.OK.getReasonPhrase())
            .data(DoctorDetailOutbound.of(doctorService.updateDoctor(doctorId, doctorInbound)))
            .build();
  }
}
