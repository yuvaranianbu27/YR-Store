package com.yuva.yuvaranistore.service;

import com.yuva.yuvaranistore.dto.ProfileRequestDto;
import com.yuva.yuvaranistore.dto.ProfileResponseDto;

public interface IProfileService {
    ProfileResponseDto getProfile();

    ProfileResponseDto updateProfile(ProfileRequestDto profileRequestDto);
}


