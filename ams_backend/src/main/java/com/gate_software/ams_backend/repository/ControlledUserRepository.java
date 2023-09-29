package com.gate_software.ams_backend.repository;

import com.gate_software.ams_backend.entity.CheckInRecords;
import com.gate_software.ams_backend.entity.ControlledUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ControlledUserRepository extends JpaRepository<ControlledUser, Integer> {
    ControlledUser findByEmail(String email);
}
