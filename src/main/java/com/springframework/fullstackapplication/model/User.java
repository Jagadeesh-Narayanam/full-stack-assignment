package com.springframework.fullstackapplication.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

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

}
