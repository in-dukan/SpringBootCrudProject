package com.example.springbootvalidatingforminput;

import com.example.springbootvalidatingforminput.model.User;
import com.example.springbootvalidatingforminput.repository.UserRepository;
import javafx.application.Application;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.bind.Name;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class SpringBootValidatingFormInputApplication implements CommandLineRunner {

    private Logger LOG = LoggerFactory.getLogger(Application.class);

    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootValidatingFormInputApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        User user1 = new User("İrem", 22, "1998-07-16");

        LOG.info("Inserting data in DB");
        userRepository.save(user1);

        LOG.info("User count in DB: {}", userRepository.count());

    }
}
