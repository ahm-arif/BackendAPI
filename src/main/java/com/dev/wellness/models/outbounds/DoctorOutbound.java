package com.dev.wellness.models.outbounds;

import com.dev.wellness.models.entities.Doctor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DoctorOutbound {

  private int doctorId;

  private String name;

  private String title;

  private String gender;

  private String DOB;

  private String phone;

  private String address;

  public static DoctorOutbound of(Doctor doctor) {
    return DoctorOutbound.builder()
            .doctorId(doctor.getDoctorId())
            .name(doctor.getName())
            .title(doctor.getTitle())
            .gender(doctor.getGender())
            .DOB(doctor.getDOB())
            .phone(doctor.getPhone())
            .address(doctor.getAddress())
            .build();
  }

}
