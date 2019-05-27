package uz.mycompany.logosofuzbekistan.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import uz.mycompany.logosofuzbekistan.collection.Role;


import java.util.Optional;


public interface RoleRepository extends MongoRepository<Role,Integer> {

    Optional<Role> findByName(String roleName);
}
