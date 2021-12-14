package com.example.springlogin;

import com.example.springlogin.dao.UserRepository;
import com.example.springlogin.dto.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;
import javax.persistence.EntityManager;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {

    @Autowired
    UserRepository userRepository;

    @Autowired
    EntityManager entityManager;

    @Test
    public void testCreateUser(){
        User user = new User();
        user.setFirstname("nawab");
        user.setLastname("nawab");
        user.setEmailid("nawab1@nawab.com");
        user.setPassword("12344");

        User savedUser = userRepository.save(user);

        User existingUser = entityManager.find(User.class,savedUser.getId());
        assertThat(existingUser.getEmailid()).isEqualTo(savedUser.getEmailid());
    }

}
