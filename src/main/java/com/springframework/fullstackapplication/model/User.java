package com.springframework.fullstackapplication.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String businessName;
    private String contactPerson;
    private String drugLicense;
    private String gst;
    private String phoneNumber;
    private String username;
    private String password;
    private boolean enabled;

    @Enumerated(EnumType.STRING)
    private Role role;

}
