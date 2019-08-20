package com.example.patient.Repository;

import com.example.patient.Model.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PatientRepository extends MongoRepository<Patient,String> {
}
