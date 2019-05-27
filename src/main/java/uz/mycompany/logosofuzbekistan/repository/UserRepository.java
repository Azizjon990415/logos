package uz.mycompany.logosofuzbekistan.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import uz.mycompany.logosofuzbekistan.collection.User;


import java.util.Optional;


public interface UserRepository  extends MongoRepository<User,Integer> {
    Optional<User> findByUsernameOrEmail(String username, String email);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
}
