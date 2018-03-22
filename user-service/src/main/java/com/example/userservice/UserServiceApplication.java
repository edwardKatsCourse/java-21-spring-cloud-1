package com.example.userservice;

import com.example.userservice.model.User;
import com.example.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Stream;

@SpringBootApplication
public class UserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }
}

@Component
class DummyCommandLineRunner implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        Stream.of("david", "peter", "maria")
                .map(x -> User.builder()
                        .username(x)
                        .build())
                .forEach(x -> userRepository.save(x));
    }
}

@RestController
class MessageController {

//    @Value("${service.message}")
    private String message;

    @GetMapping("/message")
    public String getMessage() {
        return message;
    }
}














