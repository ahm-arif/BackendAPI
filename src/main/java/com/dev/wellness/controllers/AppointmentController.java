package com.dev.wellness.controllers;

import com.dev.wellness.models.entities.Appointment;
import com.dev.wellness.models.inbounds.AppointmentInbound;
import com.dev.wellness.models.outbounds.AppointmentDetailOutbound;
import com.dev.wellness.models.outbounds.AppointmentOutbound;
import com.dev.wellness.models.outbounds.wrapper.BaseResponse;
import com.dev.wellness.models.outbounds.wrapper.DataResponse;
import com.dev.wellness.models.outbounds.wrapper.PageDataResponse;
import com.dev.wellness.models.outbounds.wrapper.Paging;
import com.dev.wellness.services.api.AppointmentService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/appointments")
public class AppointmentController {

  private final AppointmentService appointmentService;

  public AppointmentController(AppointmentService appointmentService) {
    this.appointmentService = appointmentService;
  }

  @GetMapping
  public PageDataResponse<AppointmentOutbound> getAllAppointment(
          @RequestParam(required = false,
                  defaultValue = "0")
                  int page,
          @RequestParam(required = false,
                  defaultValue = "10")
                  int size
  ) {
    Page<Appointment> appointments = appointmentService.findAll(page, size);
    Paging paging = Paging.builder()
            .page(appointments.getPageable().getPageNumber())
            .size(appointments.getSize())
            .totalRecords(appointments.getTotalElements())
            .build();

    return PageDataResponse.<AppointmentOutbound>dataBuilder()
            .code(HttpStatus.OK.value())
            .status(HttpStatus.OK.getReasonPhrase())
            .paging(paging)
            .data(appointments.get().map(AppointmentOutbound::of).collect(Collectors.toList()))
            .build();
  }

  @GetMapping(value = "/{appointmentId}")
  public DataResponse<AppointmentDetailOutbound> getAppointmentDetail(@PathVariable int appointmentId) {
    return DataResponse.<AppointmentDetailOutbound>dataBuilder()
            .code(HttpStatus.OK.value())
            .status(HttpStatus.OK.getReasonPhrase())
            .data(AppointmentDetailOutbound.of(appointmentService.findOne(appointmentId)))
            .build();
  }

  @PostMapping
  public DataResponse<AppointmentDetailOutbound> createAppointment(
          @RequestBody AppointmentInbound appointmentInbound
  ) {
    Appointment appointment = appointmentService.create(appointmentInbound);
    return DataResponse.<AppointmentDetailOutbound>dataBuilder()
            .code(HttpStatus.OK.value())
            .status(HttpStatus.OK.getReasonPhrase())
            .data(AppointmentDetailOutbound.of(appointment))
            .build();
  }

  @DeleteMapping(value = "/{appointmentId}")
  public BaseResponse deleteAppointment(
          @PathVariable int appointmentId
  ) {
    appointmentService.delete(appointmentId);
    return BaseResponse.builder()
            .code(HttpStatus.OK.value())
            .status(HttpStatus.OK.getReasonPhrase())
            .build();
  }

  @PutMapping(value = "/{appointmentId}")
  public DataResponse<AppointmentDetailOutbound> updateAppointment(
          @PathVariable int appointmentId,
          @RequestBody AppointmentInbound appointmentInbound
  ) {
    Appointment appointment = appointmentService.update(appointmentId, appointmentInbound);
    return DataResponse.<AppointmentDetailOutbound>dataBuilder()
            .code(HttpStatus.OK.value())
            .status(HttpStatus.OK.getReasonPhrase())
            .data(AppointmentDetailOutbound.of(appointment))
            .build();
  }

}
