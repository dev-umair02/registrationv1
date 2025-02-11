package com.api.registration.payload;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter


public class RegistrationDto {
  private  String name;
  private  String email;
  private  String mobileNo;


  }