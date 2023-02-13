package com.springframework.fullstackapplication.services;

import com.springframework.fullstackapplication.model.User;
import com.springframework.fullstackapplication.respositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User registerUser(User newUser){
        Optional<User> user = userRepository.findByDrugLicense(newUser.getDrugLicense());
        if(user.isEmpty()){
            return userRepository.save(newUser);
        }
        return null;

    }

    public User showDetails(String username) {
        User user = userRepository.findByUsername(username);
        if(user!=null){
            return user;
        }
        else{
            throw new UsernameNotFoundException("No user found with that username");
        }
    }

    public User editDetails(String username, User user) {
        User olduser = userRepository.findByUsername(username);
        if(olduser!=null) {
            if (user.getBusinessName() != null) {
                olduser.setBusinessName(user.getBusinessName());
            }
            if (user.getGst() != null) {
                olduser.setGst(user.getGst());
            }
            if (user.getContactPerson() != null) {
                olduser.setContactPerson(user.getContactPerson());
            }
            if (user.getDrugLicense() != null) {
                olduser.setDrugLicense(user.getDrugLicense());
            }
            if (user.getPhoneNumber() != null) {
                olduser.setPhoneNumber(user.getPhoneNumber());
            }
            return userRepository.save(olduser);
        }
        return null;


    }
    public User enableOrDisableUser (Long id){
        User user = userRepository.findById(id).orElse(null);
        user.setEnabled(!user.isEnabled());
        return userRepository.save(user);
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public User login(User user) {
        User savedUser = userRepository.findByUsername(user.getUsername());
        if(user.getPassword().equals(savedUser.getPassword())){
            return savedUser;
        }
        else{
            throw new RuntimeException();
        }
    }
}
