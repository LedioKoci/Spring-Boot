package com.example.demo.repository;

import com.example.demo.model.User;
import com.example.demo.userRepository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void checkIfExistsByEmail() {

        //given
        User user = new User(
                34,
                "gay",
                "gay",
                45,
                "gaygay@gmail.com",
                "gay03"
        );
        userRepository.save(user);

        //when
        Boolean expected = userRepository.existsByEmail(user.getEmail());

        //then
        assertThat(expected).isTrue();
    }
}