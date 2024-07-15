package com.cg.onlinesweetmart.controllertest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.cg.onlinesweetmart.controller.UserController;
import com.cg.onlinesweetmart.dto.UserResponseDto;
import com.cg.onlinesweetmart.entity.User;
import com.cg.onlinesweetmart.service.UserService;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

    // Mocking the UserService
    @Mock
    private UserService userService;

    // Injecting mocks into UserController
    @InjectMocks
    private UserController userController;

    // Setting up the test environment
    @BeforeEach
    public void setUp() {
        // No need to initialize mocks here when using @InjectMocks and @Mock annotations
    }

    // Testing the showAllUsers method
    @Test
    public void testShowAllUsers() {
        // Mocking the behavior of userService.showAllUsers() to return a list of users
        List<UserResponseDto> users = new ArrayList<>();
        users.add(new UserResponseDto(1L, "user1_name", "user1@example.com"));
        users.add(new UserResponseDto(2L, "user2_name", "user2@example.com"));
        when(userService.showAllUsers()).thenReturn(users);

        // Calling the controller method to get the result
        List<UserResponseDto> result = userController.showAllUsers();

        // Asserting the result
        assertEquals(users, result);
    }

    // Testing the updateUser method
    @Test
    public void testUpdateUser() {
        // Mocking the behavior of userService.updateUser(user) to return an updated user
        User user = new User();
        user.setUserId(1L);
        user.setUsername("user1_name");
        user.setEmail("user1@example.com");

        UserResponseDto updatedUserDto = new UserResponseDto(1L, "updatedUser", "updatedUser@example.com");
        when(userService.updateUser(user)).thenReturn(updatedUserDto);

        // Calling the controller method to update the user
        ResponseEntity<UserResponseDto> responseEntity = userController.updateUser(user);

        // Asserting the result
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(updatedUserDto, responseEntity.getBody());
    }

    
}
