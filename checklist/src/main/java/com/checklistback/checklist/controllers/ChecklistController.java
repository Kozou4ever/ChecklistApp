package com.checklistback.checklist.controllers;

import com.checklistback.checklist.models.Checklist;
import com.checklistback.checklist.payload.request.LoginRequest;
import com.checklistback.checklist.payload.response.JwtResponse;
import com.checklistback.checklist.repository.ChecklistRepository;
import com.checklistback.checklist.repository.UserRepository;
import com.checklistback.checklist.security.services.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/list")
public class ChecklistController {

    @Autowired
    ChecklistRepository checklistRepository;

    @PostMapping("/create")
    public ResponseEntity<?> createChecklist(@Valid @RequestBody String title) {
        return null;
    }
}
