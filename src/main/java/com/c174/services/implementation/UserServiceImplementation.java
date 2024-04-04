package com.c174.services.implementation;

import com.c174.exception.AlreadyExistsException;
import com.c174.models.profile.ProfileEntity;
import com.c174.models.profile.ProfileRequest;
import com.c174.models.user.*;
import com.c174.repositorys.ProfileRepository;
import com.c174.repositorys.UserRepository;
import com.c174.services.abstraccion.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImplementation implements UserService {
    private final UserRepository userRepository;
    private final ProfileRepository profileRepository;
    @Autowired
    public UserServiceImplementation(UserRepository userRepository, ProfileRepository profileRepository) {
        this.userRepository = userRepository;
        this.profileRepository = profileRepository;
    }

    @Override
    public List<UserResponse> getAllUsers() {
        List<UserEntity> users = userRepository.findAll();
        List<UserResponse> usersResponse = users.stream()
                .map(userEntity -> new UserResponse(userEntity))
                .collect(Collectors.toList());
        return usersResponse;
    }

    @Override
    public UserResponse createUser(UserRequest User) throws AlreadyExistsException {
        if(userRepository.existsByEmail(User.getMail())){
            throw new AlreadyExistsException("Email already exists");
        }
        else if(User.getProfile() == null) {
            throw new AlreadyExistsException("Profile missing");
        }

        ProfileRequest profileRequest = User.getProfile();

        ProfileEntity profileEntity = new ProfileEntity();
        profileEntity.setDocument(profileRequest.getDocument());
        profileEntity.setLastname(profileRequest.getLastname());
        profileEntity.setName(profileRequest.getName());
        profileEntity.setPresent(profileRequest.isPresent());

        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(User.getMail());
        userEntity.setPassword(User.getPassword());
        userEntity.setProfile(profileEntity);

        userEntity = userRepository.save(userEntity);

        UserResponse userResponse = new UserResponse(userEntity);

        return userResponse;
    }
}
