package com.dev.wellness.models.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentType {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int appointmentTypeId;

  private String name;

  private String description;

  private long price;

}
