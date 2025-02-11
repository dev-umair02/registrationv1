package com.api.registration.service;

import com.api.registration.entity.Registration;
import com.api.registration.payload.RegistrationDto;
import com.api.registration.repository.RegistrationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistrationsService {

    private RegistrationRepository registrationRepository;
    private ModelMapper modelMapper;

    public RegistrationsService(RegistrationRepository registrationRepository) {
        this.registrationRepository = registrationRepository;
    }

    public List<Registration> getRegistration(){

        List<Registration> registration = registrationRepository.findAll();
        return registration;


    }

    public RegistrationDto saved(RegistrationDto registrationDto) {
        Registration registration = mapToEntity(registrationDto);

        Registration savedEntity= registrationRepository.save(registration);
        RegistrationDto dto= mapToDto(savedEntity);
        return dto;
    }

    public void deleteRegistration(long id) {
        registrationRepository.deleteById(id);
    }

    public Registration updateRegistration(long id, Registration registration) {
        Registration reg = registrationRepository.findById(id).get();

        reg.setName(registration.getName());
        reg.setEmail(registration.getEmail());
        reg.setMobileNo(registration.getMobileNo());
        Registration updatedReg= registrationRepository.save(registration);
        return updatedReg;
    }

    // map to Entitu
     Registration mapToEntity(RegistrationDto registrationDto){
//        Registration registration = new Registration();
//        registration.setName(registrationDto.getName());
//        registration.setEmail(registrationDto.getEmail());
//        registration.setMobileNo(registrationDto.getMobileNo());
         Registration registration= modelMapper.map(registrationDto, Registration.class);


         return registration;
     }
     RegistrationDto mapToDto(Registration registration){
//        RegistrationDto registrationDto = new RegistrationDto();
//        registrationDto.setName(registration.getName());
//        registrationDto.setEmail(registration.getEmail());
//        registrationDto.setMobileNo(registration.getMobileNo());

         RegistrationDto registrationDto = modelMapper.map(registration, RegistrationDto.class);

         return registrationDto;

     }





}
