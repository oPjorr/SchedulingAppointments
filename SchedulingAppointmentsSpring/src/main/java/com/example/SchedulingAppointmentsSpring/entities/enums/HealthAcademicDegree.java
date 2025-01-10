package com.example.SchedulingAppointmentsSpring.entities.enums;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum HealthAcademicDegree {
    ASSOCIATE("Associate's Degree"),
    BACHELOR("Bachelor's Degree"),
    MASTER("Master's Degree"),
    DOCTORATE("Doctorate Degree"),
    MD("Doctor of Medicine"),
    DPHARM("Doctor of Pharmacy"),
    DDS("Doctor of Dental Surgery");

    private final String displayName;

    HealthAcademicDegree(String displayName) {
        this.displayName = displayName;
    }
}
