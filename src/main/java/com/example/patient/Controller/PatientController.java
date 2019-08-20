package com.example.patient.Controller;

import com.example.patient.Model.Patient;
import com.example.patient.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin("*")
public class PatientController {

    @Autowired
    PatientRepository patientRepository;

    @GetMapping("/patient")
    public List<Patient> getAllPatient() {


        return patientRepository.findAll();
    }

    @PostMapping("/patient")
    public Patient createTodo(@Valid @RequestBody Patient patient) {

        return patientRepository.save(patient);
    }

    @GetMapping(value="/patient/{id}")
    public ResponseEntity<Patient> getTodoById(@PathVariable("id") String id) {
        return patientRepository.findById(id)
                .map(patient -> ResponseEntity.ok().body(patient))
                .orElse(ResponseEntity.notFound().build());
    }

}
