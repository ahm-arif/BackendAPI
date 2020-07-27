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
public class DoctorCategory {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int doctorCategoryId;

  private String doctorCategoryCode;

  private String doctorCategoryName;

  @ManyToMany(mappedBy = "doctorCategories")
  private List<Doctor> doctors;

}
