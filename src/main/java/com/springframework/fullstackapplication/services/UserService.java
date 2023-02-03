package com.springframework.fullstackapplication.services;

import com.springframework.fullstackapplication.model.User;
import com.springframework.fullstackapplication.respositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User registerUser(User newUser){
        Optional<User> user = userRepository.findByDrugLicense(newUser.getDrugLicense());
        System.out.println(user);
        if(user.isEmpty()){
            return userRepository.save(newUser);
        }
        return null;

    }

    public Optional<User> showDetails(Long id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            return user;
        }
        return null;
    }

    public User editDetails(Long id, User user) {
        User olduser = userRepository.findById(id).orElse(null);
        if(user.getBusinessName()!=null ) {
            olduser.setBusinessName(user.getBusinessName());
        }
        if(user.getGst()!=null){
            olduser.setGst(user.getGst());
        }
        if(user.getContactPerson()!=null) {
            olduser.setContactPerson(user.getContactPerson());
        }
        if(user.getDrugLicense()!=null) {
            olduser.setDrugLicense(user.getDrugLicense());
        }
        if(user.getPhoneNumber()!=null) {
            olduser.setPhoneNumber(user.getPhoneNumber());
        }

        return userRepository.save(olduser);
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }
}
