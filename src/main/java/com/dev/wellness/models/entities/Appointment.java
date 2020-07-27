package com.dev.wellness.models.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Appointment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int appointmentId;

  @ManyToOne
  @JoinColumn(name = "doctor_id")
  private Doctor doctor;

  private int patientId;

  @ManyToOne
  @JoinColumn(name = "appointment_type_id")
  private AppointmentType appointmentType;

  private int prescriptionId;

  @ManyToOne
  @JoinColumn(name = "symptom_id")
  private Symptom symptom;

}
