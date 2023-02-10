package com.checklistback.checklist.controllers;

import com.checklistback.checklist.models.Checklist;
import com.checklistback.checklist.models.User;
import com.checklistback.checklist.payload.response.MessageResponse;
import com.checklistback.checklist.repository.ChecklistRepository;
import com.checklistback.checklist.security.services.UserDetailsServiceImpl;
import com.checklistback.checklist.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/list")
public class ChecklistController {

    @Autowired
    ChecklistRepository checklistRepository;
    @Autowired
    UserService userService;

    @GetMapping()
    public ResponseEntity<?> getChecklists(){
        return null;
    }
    //TODO return checklistDetails...

    @PostMapping("/create")
    public ResponseEntity<?> createChecklist(@Valid @RequestBody String name, Authentication authentication) {
        User currentUser = userService.findUserByName(authentication.getName());
        checklistRepository.save(new Checklist(name, currentUser));
        return ResponseEntity.ok(new MessageResponse("Checklist created successfully!"));
    }
}
