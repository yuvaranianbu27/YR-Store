package com.yuva.yuvaranistore.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.yuva.yuvaranistore.dto.ProfileRequestDto;
import com.yuva.yuvaranistore.dto.ProfileResponseDto;
import com.yuva.yuvaranistore.service.IProfileService;

@RestController
@RequestMapping("/api/v1/profile")
public class ProfileController {
    private final IProfileService iProfileService;

    public ProfileController(IProfileService iProfileService) {
        this.iProfileService = iProfileService;
    }


    @GetMapping
    public ResponseEntity<ProfileResponseDto> getProfile() {
        ProfileResponseDto responseDto = iProfileService.getProfile();
        return ResponseEntity.ok(responseDto);
    }
    @PutMapping
    public ResponseEntity<ProfileResponseDto> updateProfile(
            @Validated @RequestBody ProfileRequestDto profileRequestDto) {
        ProfileResponseDto responseDto = iProfileService.updateProfile(profileRequestDto);
        return ResponseEntity.ok(responseDto);
    }

}

