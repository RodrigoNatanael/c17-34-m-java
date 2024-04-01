package com.c174.services.implementation;
import com.c174.models.user.ProfileRequest;
import com.c174.models.user.ProfileResponse;
import com.c174.repositorys.ProfileRepository;
import com.c174.services.abstraccion.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileServiceImplements implements ProfileService {
    @Autowired
    private ProfileRepository profileRepository;

    @Override
    public ProfileResponse getProfileById(Long id) {
        return null;
    }

    @Override
    public ProfileResponse saveProfile(ProfileRequest profile) {
        return null;
    }

    @Override
    public ProfileResponse updateProfile(ProfileRequest profile) {
        return null;
    }

    @Override
    public String deleteProfile(Long id) {
        return null;
    }
}
