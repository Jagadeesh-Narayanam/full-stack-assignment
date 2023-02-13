package com.springframework.fullstackapplication.controllers;

import com.springframework.fullstackapplication.model.*;
import com.springframework.fullstackapplication.respositories.UserRepository;
import com.springframework.fullstackapplication.services.OfficeBearerService;
import com.springframework.fullstackapplication.services.ProductService;
import com.springframework.fullstackapplication.services.RegistrationService;
import com.springframework.fullstackapplication.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@CrossOrigin
public class UserController {
    private final UserService userService;
    private final ProductService productService;
    private final OfficeBearerService officeBearerService;
    private final RegistrationService registrationService;
    private final UserRepository userRepository;


    public UserController(UserService userService, ProductService productService, OfficeBearerService officeBearerService, RegistrationService registrationService,
                          UserRepository userRepository) {
        this.userService = userService;
        this.productService = productService;
        this.officeBearerService = officeBearerService;
        this.registrationService = registrationService;
        this.userRepository = userRepository;
    }

    //User
    @PostMapping("/public/register")
    public Registration registerUser(@RequestBody Registration registration){

        User existedUser = userRepository.findByUsername(registration.getUsername());
        if(existedUser==null) {
            registration.setPassword(registration.getPassword());
            return registrationService.sendRequest(registration);
        }
        else{
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username already exists!");
        }
    }
    @PostMapping("/login")
    public User login(@RequestBody User user){
        return userService.login(user);
    }

    @GetMapping("/user/{username}/profile")
    public User showUserDetails(@PathVariable String username){
        return userService.showDetails(username);
    }

    @PutMapping("user/{username}/profile/edit")
    public User editUserDetails(@PathVariable String username,@RequestBody User user){
        return userService.editDetails(username,user);
    }

    @GetMapping("/user/products")
    public List<Product> showProducts(){
        return productService.findAllProducts();
    }

    @GetMapping("/user/officeBearers")
    public List<OfficeBearer> showAllOfficeBearers(){
        return officeBearerService.findAllOfficeBearers();
    }






}
