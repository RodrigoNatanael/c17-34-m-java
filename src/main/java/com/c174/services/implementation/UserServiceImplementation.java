package com.c174.services.implementation;

import com.c174.exception.AlreadyExistsException;
import com.c174.models.user.*;
import com.c174.repositorys.ProfileRepository;
import com.c174.repositorys.UserRepository;
import com.c174.services.abstraccion.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImplementation implements UserService {
    @Autowired
    private final UserRepository userRepository;
    private final ProfileRepository profileRepository;

    public UserServiceImplementation(UserRepository userRepository, ProfileRepository profileRepository) {
        this.userRepository = userRepository;
        this.profileRepository = profileRepository;
    }

    @Override
    public List<UserResponse> getAllUsers() {
        List<UserEntity> users = userRepository.findAll();
        System.out.println(users);
        List<UserResponse> usersResponse = users.stream()
                .map(userEntity -> new UserResponse(
                        userEntity.getId(),
                        userEntity.getEmail(),
                        null
                ))
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
        UserEntity userEntity = new UserEntity(User.getMail(), User.getPassword(), null);
        userEntity = userRepository.save(userEntity);
        ProfileEntity profile = new ProfileEntity(User.getProfile().getName(),User.getProfile().getLastname(), User.getProfile().getDocument(), User.getProfile().isPresent(), userEntity);
        ProfileEntity profileEntity = profileRepository.save(profile);
        userEntity.setProfile(profileEntity);
        userEntity = userRepository.save(userEntity);
        ProfileResponse profileResponse = new ProfileResponse(profileEntity.getId(), profileEntity.getName(), profileEntity.getLastname(), profileEntity.getDocument(), profileEntity.isPresent(), null);
        UserResponse userResponse = new UserResponse(userEntity.getId(), userEntity.getEmail(), profileResponse);
        return userResponse;
    }
}
