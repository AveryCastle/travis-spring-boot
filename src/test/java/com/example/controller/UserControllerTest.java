package com.example.controller;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.TravisSpringBootApplication;
import com.example.dto.UserDto;
import com.example.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * UserController Test.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(TravisSpringBootApplication.class)
@WebAppConfiguration
public class UserControllerTest {

    private static final Long USER_ID = 1000L;

    private static final String REQUEST_JSON =
            "{\"name\":\"Marat Safin\",\"nickname\":\"actor\"," + "\"birthday\":\"800102\"}";

    private MockMvc mvc;

    @InjectMocks
    private UserController userController;

    @Mock
    private UserService userService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        UserDto userDto = UserDto.create(USER_ID, "Marat Safin", "", "800102");

        given(userService.findOne(USER_ID)).willReturn(userDto);

        mvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    public void save() throws Exception {
        mvc.perform(post("/user")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .content(REQUEST_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void find() throws Exception {
        mvc.perform(get("/user/" + USER_ID)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk());
    }
}
