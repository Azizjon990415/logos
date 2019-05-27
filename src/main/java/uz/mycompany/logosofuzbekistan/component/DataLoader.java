package uz.mycompany.logosofuzbekistan.component;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import uz.mycompany.logosofuzbekistan.collection.Role;
import uz.mycompany.logosofuzbekistan.collection.User;
import uz.mycompany.logosofuzbekistan.repository.RoleRepository;
import uz.mycompany.logosofuzbekistan.repository.UserRepository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;


@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    List<User> user;
    @PostConstruct
    void init() {
        roleRepository.save(new Role(0,"ROLE_ADMIN"));
        roleRepository.save(new Role(0,"ROLE_MODER"));
        roleRepository.save(new Role(0,"ROLE_USER"));
        this.user = new ArrayList<>();


    }

    @Override
    public void run(String... args) throws Exception {

            userRepository.save(new User("superAdmin","superadmin@gmail.com", passwordEncoder.encode("1930"),
                    "Adminstrator",roleRepository.findAll()));

    }
}
