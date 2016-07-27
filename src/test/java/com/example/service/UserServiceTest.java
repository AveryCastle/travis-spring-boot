package com.example.service;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.BDDMockito.given;

import com.example.domain.User;
import com.example.dto.UserDto;
import com.example.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * UserService Test.
 */
public class UserServiceTest {

    private static final Long USER_ID = 1000L;

    public static final String USER_NAME = "Estel Castle";

    @Mock
    private UserRepository userRepository;

    private UserService userService;

    private User user;

    @Before
    public void setUp() {
        // Given

        MockitoAnnotations.initMocks(this);

        user = User.create(USER_ID, USER_NAME, "pikanpie", "101112");

        given(userRepository.save(user)).willReturn(user);

        given(userRepository.findOne(USER_ID)).willReturn(user);

        userService = new UserService(userRepository);
    }

    @Test
    public void save() {
        // When
        UserDto userDto = userService.save(user);

        // Then
        assertThat(userDto.getId(), equalTo(USER_ID.toString()));
    }

    @Test
    public void find() {
        // When
        UserDto userDto = userService.findOne(USER_ID);

        // Then
        assertThat(userDto.getName(), equalTo(USER_NAME));
    }
}
