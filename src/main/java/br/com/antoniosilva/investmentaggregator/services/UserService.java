package br.com.antoniosilva.investmentaggregator.services;

import br.com.antoniosilva.investmentaggregator.dtos.CreateUserDto;
import br.com.antoniosilva.investmentaggregator.entities.User;
import br.com.antoniosilva.investmentaggregator.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UUID createUser(CreateUserDto createUserDto) {
        // DTO -> ENTITY
        var userEntity = new User(
                UUID.randomUUID(),
                createUserDto.username(),
                createUserDto.email(),
                createUserDto.password(),
                Instant.now(),
                null
        );
        var userSaved = userRepository.save(userEntity);
        return userSaved.getUserId();
    }
}
