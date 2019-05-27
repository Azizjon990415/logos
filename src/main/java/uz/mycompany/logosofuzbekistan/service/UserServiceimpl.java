package uz.mycompany.logosofuzbekistan.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import uz.mycompany.logosofuzbekistan.collection.Role;
import uz.mycompany.logosofuzbekistan.collection.User;
import uz.mycompany.logosofuzbekistan.repository.RoleRepository;
import uz.mycompany.logosofuzbekistan.repository.UserRepository;


import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceimpl implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;





    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional <User> optional=userRepository.findByUsernameOrEmail(username,username);
        return optional.orElseThrow(()->new UsernameNotFoundException(username));
    }
}
