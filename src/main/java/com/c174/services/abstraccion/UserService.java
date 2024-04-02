package com.c174.services.abstraccion;

import com.c174.exception.AlreadyExistsException;
import com.c174.models.user.UserRequest;
import com.c174.models.user.UserResponse;

import java.util.List;

public interface UserService {
    List<UserResponse> getAllUsers();

    UserResponse createUser(UserRequest User) throws AlreadyExistsException;
}
