package uz.mycompany.logosofuzbekistan.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import uz.mycompany.logosofuzbekistan.collection.Role;
import uz.mycompany.logosofuzbekistan.collection.User;
import uz.mycompany.logosofuzbekistan.payload.JwtResponse;
import uz.mycompany.logosofuzbekistan.payload.LoginReq;
import uz.mycompany.logosofuzbekistan.payload.UserReq;
import uz.mycompany.logosofuzbekistan.repository.RoleRepository;
import uz.mycompany.logosofuzbekistan.repository.UserRepository;
import uz.mycompany.logosofuzbekistan.security.JwtProvider;


import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.lang.reflect.Array;
import java.net.URI;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("/api/auth")
@Api(description = "Set of Registration.")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtProvider jwtProvider;

    @RequestMapping(value = "/signin",method = RequestMethod.POST)
    @ApiOperation("${AuthController.signin}")
    public ResponseEntity<?> signIn(@Valid @RequestBody LoginReq loginReq){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginReq.getUsername(),
                        loginReq.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtProvider.generateJwtToken(authentication);
        return ResponseEntity.ok(new JwtResponse(jwt));
    }
    @PostMapping("/signup")
    @ApiOperation("${AuthController.signin}")
    public ResponseEntity<?> signup(@Valid @RequestBody UserReq userReq, HttpServletResponse response){
        if(userRepository.existsByUsername(userReq.getUsername())) {
            return new ResponseEntity<String>("Fail -> Username is already taken!",
                    HttpStatus.BAD_REQUEST);
        }

        if(userRepository.existsByEmail(userReq.getEmail())) {
            return new ResponseEntity<String>("Fail -> Email is already in use!",
                    HttpStatus.BAD_REQUEST);
        }

        // Creating user's account
        User user = new User(userReq.getName(), userReq.getUsername(),
                userReq.getEmail(), userReq.getPassword());

        user.setPassword(encoder.encode(user.getPassword()));

        Role userRole = roleRepository.findByName("ROLE_USER")
                .orElseThrow(() -> new RuntimeException("User Role not set."));

        user.setRoles(Collections.singletonList(userRole));
        List<User> baseUsers=userRepository.findAll();
        if (baseUsers==null){
            user.setId(0);

        }
        else {
            IdComparator idComparator = new IdComparator();
            Collections.sort(baseUsers, idComparator);
        user.setId(baseUsers.get(baseUsers.size()-1).getId()+1);

        }

        User result = userRepository.save(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/api/users/{username}")
                .buildAndExpand(result.getUsername()).toUri();
//         response.
        return ResponseEntity.ok().body("User registered successfully!");
    }
}
class IdComparator implements Comparator<User> {

    public int compare(User h1, User h2) {
        if (h1.getId() == h2.getId()) {
            return 0;
        }
        if (h1.getId() > h2.getId()) {
            return 1;
        }
        else {
            return -1;
        }
    }
}