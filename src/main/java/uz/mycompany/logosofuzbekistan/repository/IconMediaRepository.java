package uz.mycompany.logosofuzbekistan.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import uz.mycompany.logosofuzbekistan.collection.IconMedia;

public interface IconMediaRepository extends MongoRepository<IconMedia,Integer> {
}
