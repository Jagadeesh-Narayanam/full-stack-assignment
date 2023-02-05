package com.springframework.fullstackapplication.services;

import com.springframework.fullstackapplication.model.Registration;
import com.springframework.fullstackapplication.respositories.RegistrationRepository;
import com.springframework.fullstackapplication.respositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegistrationService {
    private RegistrationRepository registrationRepository;
    private UserRepository userRepository;

    public RegistrationService(RegistrationRepository registrationRepository, UserRepository userRepository) {
        this.registrationRepository = registrationRepository;
        this.userRepository = userRepository;
    }

    public Registration sendRequest(Registration registration) {
        return registrationRepository.save(registration);
    }
    public List<Registration> showAllRegistrations(){
        return registrationRepository.findAll();
    }
    public Registration findById(Long id){
        return registrationRepository.findById(id).orElse(null);
    }
    public void deleteById(Long id){
        registrationRepository.deleteById(id);
    }


}
