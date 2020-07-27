package com.dev.wellness.models.inbounds;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AppointmentInbound {

  private Integer doctorId;

  private Integer appointmentTypeId;

  private Integer prescriptionId;

  private Integer symptomId;

  private Integer patientId;

}
