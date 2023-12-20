package br.com.antoniosilva.investmentaggregator.controllers;

import br.com.antoniosilva.investmentaggregator.dtos.CreateUserDto;
import br.com.antoniosilva.investmentaggregator.entities.User;
import br.com.antoniosilva.investmentaggregator.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody CreateUserDto createUserDto) {
        var userID = userService.createUser(createUserDto);
        return ResponseEntity.created(URI.create("/api/v1/users/" + userID)).build();
    }
}
