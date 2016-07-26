package com.example.repository;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import com.example.TravisSpringBootApplication;
import com.example.domain.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * User Repository Test.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(TravisSpringBootApplication.class)
@Transactional
public class UserRepositoryTest {

    private static final String USER_NAME = "estel";

    @Autowired
    private UserRepository userRepository;

    private int initialCountOfUser = 0;

    private Long userId;

    @Before
    public void setUp() {
        List<User> users = userRepository.findAll();
        initialCountOfUser = users.size();

        User user = User.create(USER_NAME, "pikanpie", "001011");

        userRepository.save(user);

        userId = user.getId();
    }

    @Test
    public void increaseCountOfUser() {
        int countOfUser = userRepository.findAll().size();

        assertThat(countOfUser, equalTo(initialCountOfUser + 1));
    }

    @Test
    public void findUser() {
        User user = userRepository.findOne(userId);

        assertThat(user.getName(), equalTo(USER_NAME));
    }
}
