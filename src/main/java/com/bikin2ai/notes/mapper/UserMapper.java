package com.bikin2ai.notes.mapper;

import com.bikin2ai.notes.dto.request.UserCreationDTO;
import com.bikin2ai.notes.dto.response.UserDTO;
import com.bikin2ai.notes.entity.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {
    User userCreationDtoToUser(UserCreationDTO userDTO);
    UserDTO userToUserDto (User user);
}
