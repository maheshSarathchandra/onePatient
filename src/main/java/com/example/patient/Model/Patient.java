package com.example.patient.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="patient")
public class Patient {

    @Id
    private String id;




    private String name;

    public Patient(){
        super();
    }

    public Patient(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format(
                "Patient[id=%s, name='%s']",
                id, name);
    }
}
