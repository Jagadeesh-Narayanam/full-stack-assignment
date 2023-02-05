package com.springframework.fullstackapplication.controllers;

import com.springframework.fullstackapplication.model.OfficeBearer;
import com.springframework.fullstackapplication.model.Product;
import com.springframework.fullstackapplication.model.Registration;
import com.springframework.fullstackapplication.model.User;
import com.springframework.fullstackapplication.respositories.UserRepository;
import com.springframework.fullstackapplication.services.OfficeBearerService;
import com.springframework.fullstackapplication.services.ProductService;
import com.springframework.fullstackapplication.services.RegistrationService;
import com.springframework.fullstackapplication.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(exposedHeaders = "Access-Control-Allow-Origin")
public class UserController {
    private UserService userService;
    private ProductService productService;
    private OfficeBearerService officeBearerService;
    private RegistrationService registrationService;
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
    @PostMapping("/register")
    public Registration registerUser(@RequestBody Registration registration){

//        return userService.registerUser(user);
        return registrationService.sendRequest(registration);
    }

    @GetMapping("/user/{id}/profile")
    public Optional<User> showUserDetails(@PathVariable Long id){
        return userService.showDetails(id);
    }

    @PutMapping("user/{id}/profile/edit")
    public User editUserDetails(@PathVariable Long id,@RequestBody User user){
        return userService.editDetails(id,user);
    }

    @GetMapping("/user/products")
    public List<Product> showProducts(){
        return productService.findAllProducts();
    }

    @GetMapping("/user/officeBearers")
    public List<OfficeBearer> showAllOfficeBearers(){
        return officeBearerService.findAllOfficeBearers();
    }



    //Admin
    @PostMapping("/admin/add_new_products")
    public List<Product> addProducts(@RequestBody List<Product> products){
        return productService.addProductsList(products);
    }

    @GetMapping("/admin/users")
    public List<User> showAllUsers(){
        return userService.findAllUsers();
    }
    @PostMapping("/admin/add_new_office_bearer")
    public OfficeBearer addNewOfficeBearer(@RequestBody OfficeBearer officeBearer){
        return officeBearerService.addNewOfficeBearer(officeBearer);
    }

    @GetMapping("/admin/new_requests")
    public List<Registration> showAllNewRequests(){
        return registrationService.showAllRegistrations();
    }

    @GetMapping("admin/new_requests/{id}/accept")
    public User acceptRegistration(@PathVariable Long id){
        Registration registration = registrationService.findById(id);
//        System.out.println(registration);
        User newUser = new User();
        newUser.setBusinessName(registration.getBusinessName());
        newUser.setContactPerson(registration.getContactPerson());
        newUser.setDrugLicense(registration.getDrugLicense());
        newUser.setGst(registration.getGst());
        newUser.setPhoneNumber(registration.getPhoneNumber());
        registrationService.deleteById(id);
        return userService.registerUser(newUser);

    }
    @GetMapping("admin/new_requests/{id}/decline")
    public String declineRegistration(@PathVariable Long id){
        registrationService.deleteById(id);
        return "Registration Request Deleted";
    }


}
