package uz.mycompany.logosofuzbekistan.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import uz.mycompany.logosofuzbekistan.collection.Icon;

import java.util.List;

public interface IconRepository  extends MongoRepository<Icon,Integer> {
    List<Icon> getAllByCompanyService(String companyService);
}
