package com.uol.api.service;

import com.uol.api.model.User;
import com.uol.api.model.dto.UserDto;
import com.uol.api.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;

    public User saveUser(UserDto userDto){
        User user = modelMapper.map(userDto, User.class);
        return userRepository.save(user);
    }
}
