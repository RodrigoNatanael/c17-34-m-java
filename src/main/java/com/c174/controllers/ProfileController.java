package com.c174.controllers;

import com.c174.models.user.ProfileRequest;
import com.c174.services.abstraccion.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profile")
public class ProfileController {
    @Autowired
    private ProfileService profileService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getProfileById(@PathVariable Long id){
        return ResponseEntity.ok(profileService.getProfileById(id));
    }
    @PostMapping("/save")
    public ResponseEntity<?> saveProfile(@RequestBody ProfileRequest profile){
        return ResponseEntity.ok(profileService.saveProfile(profile));
    }

    @PatchMapping("/update")
    public ResponseEntity<?> updateProfile(@RequestBody ProfileRequest profile){
        return ResponseEntity.ok(profileService.updateProfile(profile));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProfile(@PathVariable Long id){
        return ResponseEntity.ok(profileService.deleteProfile(id));
    }
}
