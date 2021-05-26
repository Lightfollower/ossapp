package com.ossapp.mainapp.service;

import com.ossapp.mainapp.dto.RequestUserDto;
import com.ossapp.mainapp.dto.UserDto;
import com.ossapp.mainapp.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    User save(RequestUserDto requestUserDto);

    User findById(Long id);

    List<UserDto> findAll(int page);
}
