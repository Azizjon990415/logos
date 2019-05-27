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



    @Override
    public void run(String... args) throws Exception {
        roleRepository.save(new Role(0,"ROLE_ADMIN"));
        roleRepository.save(new Role(0,"ROLE_MODER"));
        roleRepository.save(new Role(0,"ROLE_USER"));
             userRepository.save(
                    new User(1,"superAdmin",
                    "superadmin@gmail.com",
                            "Adminstrator",
                    passwordEncoder.encode("123456"),

                    roleRepository.findAll(),true,true,true,true));

    }
}
