package com.gate_software.ams_backend.service;

import com.gate_software.ams_backend.dto.AuthenticatedUserDTO;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.gate_software.ams_backend.entity.AdministrativeUser;
import com.gate_software.ams_backend.entity.ControlledUser;
import com.gate_software.ams_backend.repository.AdministrativeUserRepository;
import com.gate_software.ams_backend.repository.ControlledUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private final AdministrativeUserRepository administrativeUserRepository;
    private final ControlledUserRepository controlledUserRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public LoginService(
            AdministrativeUserRepository administrativeUserRepository,
            ControlledUserRepository controlledUserRepository,
            PasswordEncoder passwordEncoder) {
        this.administrativeUserRepository = administrativeUserRepository;
        this.controlledUserRepository = controlledUserRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public AuthenticatedUserDTO authenticate(String email, String password) {
        AdministrativeUser administrativeUser = administrativeUserRepository.findByEmail(email);

        if (administrativeUser != null && passwordEncoder.matches(password, administrativeUser.getPassword())) {
            return new AuthenticatedUserDTO(administrativeUser.getId(), "administrative");
        }

        ControlledUser controlledUser = controlledUserRepository.findByEmail(email);

        if (controlledUser != null && passwordEncoder.matches(password, controlledUser.getPassword())) {
            return new AuthenticatedUserDTO(controlledUser.getId(), "controlled");
        }

        return null;
    }
}