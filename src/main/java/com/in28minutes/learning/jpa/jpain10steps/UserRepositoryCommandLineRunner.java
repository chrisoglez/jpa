package com.in28minutes.learning.jpa.jpain10steps;

import com.in28minutes.learning.jpa.jpain10steps.entity.User;
import com.in28minutes.learning.jpa.jpain10steps.entity.UserRepository;
import com.in28minutes.learning.jpa.jpain10steps.service.UserDAOService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
public class UserRepositoryCommandLineRunner implements CommandLineRunner{

    private static final org.slf4j.Logger log =
            LoggerFactory.getLogger(UserRepositoryCommandLineRunner.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User user = new User("Jill", "Admin");
        // New User is created : User{id=1, name='Jack', role='Admin'}
        userRepository.save(user);
        log.info("New User is created : " + user);

        Optional<User> userWithIdOne = userRepository.findById(1L);
        log.info("User is retrieved : " + userWithIdOne);

        List<User> users = userRepository.findAll();
        log.info("All Users : " + users);
    }
}
