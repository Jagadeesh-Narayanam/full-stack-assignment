package com.springframework.fullstackapplication.controllers;

import com.springframework.fullstackapplication.model.OfficeBearer;
import com.springframework.fullstackapplication.model.Product;
import com.springframework.fullstackapplication.model.User;
import com.springframework.fullstackapplication.services.OfficeBearerService;
import com.springframework.fullstackapplication.services.ProductService;
import com.springframework.fullstackapplication.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    private UserService userService;
    private ProductService productService;
    private OfficeBearerService officeBearerService;

    public UserController(UserService userService, ProductService productService, OfficeBearerService officeBearerService) {
        this.userService = userService;
        this.productService = productService;
        this.officeBearerService = officeBearerService;
    }

    //User
    @PostMapping("/register")
    public User registerUser(@RequestBody User user){
        return userService.registerUser(user);
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
    @PostMapping("/admin/new_products")
    public List<Product> addProducts(@RequestBody List<Product> products){
        return productService.addProductsList(products);
    }

    @GetMapping("/admin/users")
    public List<User> showAllUsers(){
        return userService.findAllUsers();
    }
    @PostMapping("/admin/new_office_bearer")
    public OfficeBearer addNewOfficeBearer(@RequestBody OfficeBearer officeBearer){
        return officeBearerService.addNewOfficeBearer(officeBearer);
    }


}
