package com.springframework.fullstackapplication.respositories;

import com.springframework.fullstackapplication.model.OfficeBearer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfficeBearerRepository extends JpaRepository<OfficeBearer,Long> {
}
