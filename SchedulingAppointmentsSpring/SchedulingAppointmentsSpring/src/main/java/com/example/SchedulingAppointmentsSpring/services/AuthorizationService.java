//package com.example.SchedulingAppointmentsSpring.services;
//
//import com.example.SchedulingAppointmentsSpring.entities.user.User;
//import com.example.SchedulingAppointmentsSpring.repositories.UserRepository;
//import com.example.SchedulingAppointmentsSpring.entities.user.Doctor;
//import com.example.SchedulingAppointmentsSpring.entities.user.Pacient;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//public class AuthorizationService implements UserDetailsService {
//
//    @Autowired
//    private UserRepository repository;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        // Carregar o usuário comum da tabela "tb_user"
//        User user = (User) repository.findByLogin(username);
//
//        if (user == null) {
//            throw new UsernameNotFoundException("User not found");
//        }
//
//        // Carregar as subclasses específicas (Doctor ou Pacient)
//        if (user instanceof Doctor) {
//            // Se for um Doctor, carregue os dados específicos do Doctor
//            return (Doctor) user;
//        } else if (user instanceof Pacient) {
//            // Se for um Pacient, carregue os dados específicos do Pacient
//            return (Pacient) user;
//        }
//
//        // Caso não seja nem Doctor nem Pacient, retorna um usuário genérico (ou pode lançar uma exceção)
//        return user;
//    }
//}
