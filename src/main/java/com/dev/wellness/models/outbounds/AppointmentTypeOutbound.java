package com.dev.wellness.models.outbounds;

import com.dev.wellness.models.entities.AppointmentType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AppointmentTypeOutbound {

  private int appointmentTypeId;

  private String name;

  private String description;

  private long price;

  public static AppointmentTypeOutbound of(AppointmentType appointmentType) {
    return AppointmentTypeOutbound.builder()
            .appointmentTypeId(appointmentType.getAppointmentTypeId())
            .description(appointmentType.getDescription())
            .name(appointmentType.getName())
            .price(appointmentType.getPrice())
            .build();
  }

}
