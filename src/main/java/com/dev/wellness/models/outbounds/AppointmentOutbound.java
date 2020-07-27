package com.dev.wellness.models.outbounds;

import com.dev.wellness.models.entities.Appointment;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AppointmentOutbound {

  private int appointmentId;

  public static AppointmentOutbound of(Appointment appointment) {
    return AppointmentOutbound.builder()
            .appointmentId(appointment.getAppointmentId())
            .build();
  }

}
