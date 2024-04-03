package com.c174.services.abstraccion;

import com.c174.models.user.ProfileRequest;
import com.c174.models.user.ProfileResponse;

public interface ProfileService {
    ProfileResponse getProfileById(Long id);
    ProfileResponse saveProfile(ProfileRequest profile);
    ProfileResponse updateProfile(ProfileRequest profile);
    String deleteProfile(Long id);


}