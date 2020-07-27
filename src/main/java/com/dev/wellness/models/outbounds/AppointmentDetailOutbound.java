package com.dev.wellness.models.outbounds;

import com.dev.wellness.models.entities.Appointment;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AppointmentDetailOutbound {

  private int appointmentId;

  private DoctorOutbound doctor;

  private int patientId;

  private int prescriptionId;

  private AppointmentTypeOutbound appointmentType;

  private SymptomOutbound symptom;

  public static AppointmentDetailOutbound of(Appointment appointment) {
    return AppointmentDetailOutbound.builder()
            .appointmentId(appointment.getAppointmentId())
            .doctor(DoctorOutbound.of(appointment.getDoctor()))
            .patientId(appointment.getPatientId())
            .prescriptionId(appointment.getPrescriptionId())
            .appointmentType(AppointmentTypeOutbound.of(appointment.getAppointmentType()))
            .symptom(SymptomOutbound.of(appointment.getSymptom()))
            .build();
  }

}
