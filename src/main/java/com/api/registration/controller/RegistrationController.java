package com.api.registration.controller;

import com.api.registration.entity.Registration;

import com.api.registration.payload.RegistrationDto;
import com.api.registration.service.RegistrationsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/v1/registration")
// url:http://localhost:8081/api/v1/registration
public class RegistrationController {
    private RegistrationsService registrationsService;

    public RegistrationController(RegistrationsService registrationsService) {
        this.registrationsService = registrationsService;
    }
    //Get All the data from DB
    @GetMapping
    public ResponseEntity<List<Registration>> getAllRegistration(){

        List<Registration> registration= registrationsService.getRegistration();
        return  new ResponseEntity<>(registration, HttpStatus.OK) ;


    }

    // Save the data in DB
    @PostMapping
    public ResponseEntity<RegistrationDto> saveRegistration(@RequestBody RegistrationDto registrationDto){
        RegistrationDto registrationDto1 = registrationsService.saved(registrationDto);
        return new ResponseEntity<>(registrationDto1,HttpStatus.CREATED);

    }
    @DeleteMapping
    public ResponseEntity<String>deleteRegistration(@RequestParam long id ){
        registrationsService.deleteRegistration(id);
        return new ResponseEntity<>("Deleted",HttpStatus.OK);

    }
    @PutMapping("/{id}")
    public ResponseEntity<Registration> updateRegistration(@PathVariable long id,@RequestBody Registration registration){
        Registration updatedRegistration = registrationsService.updateRegistration(id, registration);
        return new ResponseEntity<>(updatedRegistration,HttpStatus.OK);
    }

}
