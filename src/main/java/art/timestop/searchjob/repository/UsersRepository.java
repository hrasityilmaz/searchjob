package art.timestop.searchjob.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import art.timestop.searchjob.entity.Users;

public interface UsersRepository extends JpaRepository<Users, Integer> {
    Optional<Users> findByEmail(String email); 
}
