package com.uol.api.service;

import com.uol.api.model.User;
import com.uol.api.model.dto.UserDto;
import com.uol.api.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.when;

@SpringBootTest
public class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private ModelMapper modelMapper;

    private UserDto userDto;

    private User user;

    @BeforeEach
    void setup() {
        userDto = userDto();
        user = user();
    }

    @Test
    void GivenSaveUserWithSuccessful(){
        when(modelMapper.map(userDto, User.class)).thenReturn(user);
        assertDoesNotThrow(() -> userService.saveUser(userDto));
    }


    UserDto userDto() {
        return new UserDto("Gabriel Gama", "gabriel@gabriel.com", "(27)999999999");
    }

    User user(){
        return new User(1, "Gabriel Gama", "gabriel@gabriel.com", "(27)999999999");
    }

}
