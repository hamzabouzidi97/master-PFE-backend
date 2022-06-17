package com.rh.done.service;

import com.rh.done.converter.UserConverter;
import com.rh.done.dto.UserDto;
import com.rh.done.entity.User;
import com.rh.done.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    UserConverter userConverter;


}
