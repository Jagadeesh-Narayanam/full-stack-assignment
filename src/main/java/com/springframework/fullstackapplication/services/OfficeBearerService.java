package com.springframework.fullstackapplication.services;

import com.springframework.fullstackapplication.model.OfficeBearer;
import com.springframework.fullstackapplication.respositories.OfficeBearerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfficeBearerService {
    @Autowired
    private OfficeBearerRepository officeBearerRepository;
    public OfficeBearer addNewOfficeBearer(OfficeBearer officeBearer){
        return officeBearerRepository.save(officeBearer);
    }

    public List<OfficeBearer> findAllOfficeBearers() {
        return officeBearerRepository.findAll();
    }
}
