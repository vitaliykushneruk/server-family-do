package com.kushneruk.vitaliy.serverfamilydo.persistence;

import com.google.common.collect.Iterables;
import com.kushneruk.vitaliy.serverfamilydo.TestContextConfiguration;
import com.kushneruk.vitaliy.serverfamilydo.persistence.dao.UserRepository;
import com.kushneruk.vitaliy.serverfamilydo.persistence.model.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNotNull;

public class UserRepositoryTest extends TestContextConfiguration {
    @Autowired
    UserRepository userRepository;

    final String userName = "oper";
    final String password = "oper_pass";

    @Before
    public void init(){

        User user = User.builder().userName(userName).password(password).build();
        userRepository.save(user);
    }

    @After
    public void clear(){

        userRepository.deleteAll();
    }

    @Test
    public void findAll(){

        assertThat(1, equalTo(Iterables.size(userRepository.findAll())));
    }

    @Test
    public void  findByUsername() {

        User user = userRepository.findUserByUserName(userName);
        assertNotNull(user.getId());
    }
}