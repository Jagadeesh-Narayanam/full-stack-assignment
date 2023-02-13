package com.springframework.fullstackapplication.model;

import jakarta.persistence.*;
import lombok.*;


import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Size(min=5,max=50)
    private String businessName;
    @Size(max=50)
    private String contactPerson;
    @Size(max=20)
    private String drugLicense;
    @Size(max=15)
    private String gst;
    @Size(min=10,max=10)
    private String phoneNumber;
    private String username;
    private String password;
    private boolean enabled;
    @Enumerated(EnumType.STRING)
    private Role role;

}
