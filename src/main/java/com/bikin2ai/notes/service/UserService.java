package com.bikin2ai.notes.service;

import com.bikin2ai.notes.dto.request.UserCreationDTO;
import com.bikin2ai.notes.dto.response.UserDTO;

import java.util.Optional;
import java.util.UUID;

public interface UserService {
    UserDTO createUser (UserCreationDTO body);
    Optional<UserDTO> getUserByID(UUID id);
}
