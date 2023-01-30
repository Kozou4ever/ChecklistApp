package com.checklistback.checklist.controllers;

import com.checklistback.checklist.models.Checklist;
import com.checklistback.checklist.models.User;
import com.checklistback.checklist.payload.response.ChecklistResponse;
import com.checklistback.checklist.payload.response.JwtResponse;
import com.checklistback.checklist.payload.response.MessageResponse;
import com.checklistback.checklist.repository.ChecklistRepository;
import com.checklistback.checklist.security.jwt.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/list")
public class ChecklistController {

    @Autowired
    ChecklistRepository checklistRepository;

    @GetMapping()
    public ResponseEntity<?> getChecklists(){
        return null;
    }
    //TODO return checklistDetails... 

    @PostMapping("/create")
    public ResponseEntity<?> createChecklist(@Valid @RequestBody Checklist checklist) {
        checklistRepository.save(checklist);
        return ResponseEntity.ok(new MessageResponse("Checklist created successfully!"));
    }
}
