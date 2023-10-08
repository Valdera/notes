package com.bikin2ai.notes.service.impl;

import com.bikin2ai.notes.dto.request.NoteCreationDTO;
import com.bikin2ai.notes.dto.request.UserCreationDTO;
import com.bikin2ai.notes.dto.response.NoteDTO;
import com.bikin2ai.notes.dto.response.UserDTO;
import com.bikin2ai.notes.mapper.UserMapper;
import com.bikin2ai.notes.repository.UserRepository;
import com.bikin2ai.notes.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserDTO createUser(UserCreationDTO body) {
        return  userMapper.userToUserDto(
                userRepository.save(
                        userMapper.userCreationDtoToUser(body)
                )
        );
    }

    @Override
    public Optional<UserDTO> getUserByID(UUID id) {
        return Optional.ofNullable(
            userMapper.userToUserDto(
                    userRepository.findById(id).orElse(null)
            )
        );
    }
}
