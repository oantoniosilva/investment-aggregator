package br.com.antoniosilva.investmentaggregator.repositories;

import br.com.antoniosilva.investmentaggregator.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
