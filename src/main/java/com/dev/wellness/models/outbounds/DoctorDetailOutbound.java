package com.dev.wellness.models.outbounds;

import com.dev.wellness.models.entities.Appointment;
import com.dev.wellness.models.entities.Doctor;
import com.dev.wellness.models.entities.DoctorCategory;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
@Builder
public class DoctorDetailOutbound {

  private int doctorId;

  private String name;

  private String title;

  private String gender;

  private String DOB;

  private String phone;

  private String address;

  private int appuserId;

  private List<AppointmentOutbound> appointments;

  private List<DoctorCategoryOutbound> doctorCategories;

  public static DoctorDetailOutbound of(Doctor doctor) {

    List<Appointment> appointments = Optional.ofNullable(doctor.getAppointments()).orElse(new ArrayList<>());
    List<DoctorCategory> categories = Optional.ofNullable(doctor.getDoctorCategories()).orElse(new ArrayList<>());


    return DoctorDetailOutbound.builder()
            .doctorId(doctor.getDoctorId())
            .name(doctor.getName())
            .title(doctor.getTitle())
            .gender(doctor.getGender())
            .DOB(doctor.getDOB())
            .phone(doctor.getPhone())
            .address(doctor.getAddress())
            .appointments(appointments
                    .stream()
                    .map(AppointmentOutbound::of)
                    .collect(Collectors.toList()))
            .doctorCategories(categories
                    .stream()
                    .map(DoctorCategoryOutbound::of)
                    .collect(Collectors.toList()))
            .appuserId(doctor.getAppuserId())
            .build();

  }

}
