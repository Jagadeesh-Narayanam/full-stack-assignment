package com.springframework.fullstackapplication.respositories;

import com.springframework.fullstackapplication.model.Registration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationRepository extends JpaRepository<Registration,Long> {

}
