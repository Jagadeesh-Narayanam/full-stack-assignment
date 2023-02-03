package com.springframework.fullstackapplication.respositories;

import com.springframework.fullstackapplication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByDrugLicense(String drugLicense);
}
