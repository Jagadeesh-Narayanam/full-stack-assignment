package com.springframework.fullstackapplication.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Registration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min = 5,max = 50)
    private String businessName;
    @Size(max=50)
    private String contactPerson;
    @Size(max=20)
    private String drugLicense;
    @Size(max = 15)
    private String gst;
    @Size(min=10,max=10)
    private String phoneNumber;
    private String username;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;

}
