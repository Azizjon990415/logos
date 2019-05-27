package uz.mycompany.logosofuzbekistan.collection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class User implements UserDetails {

    private Integer id;


    @Size(min = 3, max = 50)
    private String username;


    @Size(max = 50)
    @Email
    private String email;


    @Size(min = 3, max = 50)
    private String name;
//
//    @NotBlank
    @Size(min=6, max = 100)
    private String password;

     @DBRef
    private List<Role> roles= new ArrayList<>();


    private boolean accountNonExpired = true;
    private boolean accountNonLocked = true;
    private boolean credentialsNonExpired = true;
    private boolean enabled = true;

//    private Collection<? extends GrantedAuthority> authorities;

    public User(Integer id, String name, String username, String email, String password, List<GrantedAuthority> authorities) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
//        this.authorities = authorities;
    }

    public User(String name, String username, String email, String password) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User(String username, String email, String password,String name , List<Role> roles) {
        this.username = username;
        this.email = email;
        this.password = password;
      this.name=name;
        this.roles = roles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles;
    }

    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

//    public static User create(User user) {
//        List<GrantedAuthority> authorities = user.getRoles().stream().map(role ->
//                new SimpleGrantedAuthority(role.getName())
//        ).collect(Collectors.toList());
//        return new User(
//                user.getId(),
//                user.getName(),
//                user.getUsername(),
//                user.getEmail(),
//                user.getPassword(),
//                authorities
//        );
//    }
}