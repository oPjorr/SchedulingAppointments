//package com.example.SchedulingAppointmentsSpring.controllers;
//
//import com.example.SchedulingAppointmentsSpring.entities.user.Doctor;
//import com.example.SchedulingAppointmentsSpring.entities.user.Pacient;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class AppointmentController {
//
//    @GetMapping("/doctor")
//    public String doctorInfo(@AuthenticationPrincipal Doctor doctor) {
//        return "Doctor info: "; // + doctor.getSpeciallity();
//    }
//
//    @GetMapping("/pacient")
//    public String pacientInfo(@AuthenticationPrincipal Pacient pacient) {
//        return "Pacient info: "; // + pacient.getAge();
//    }
//}
