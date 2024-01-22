package com.saosexam.service1.service;

import com.saosexam.service1.dto.UserDto;
import com.saosexam.service1.model.User;

public interface UserService {

    User save(UserDto userDto);
}
