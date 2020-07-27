package com.dev.wellness.models.inbounds;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DoctorInbound {
  private String name;
  private String title;
  private String gender;
  private String DOB;
  private String phone;
  private String address;
  private Integer appuserId;
  private List<Integer> doctorCategories;
}
