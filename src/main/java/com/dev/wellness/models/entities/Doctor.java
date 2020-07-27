package com.dev.wellness.models.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int doctorId;

  private String name;

  private String title;

  private String gender;

  private String DOB;

  private String phone;

  private String address;

  private int appuserId;

  @OneToMany(mappedBy = "doctor")
  private List<Appointment> appointments;

  @ManyToMany
  @JoinTable(
          name = "doctor_doctor_category",
          joinColumns = @JoinColumn(name = "doctor_id"),
          inverseJoinColumns = @JoinColumn(name = "doctor_category_id")
  )
  private List<DoctorCategory> doctorCategories;

}
