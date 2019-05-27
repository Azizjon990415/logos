package uz.mycompany.logosofuzbekistan.collection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Role implements GrantedAuthority {

    private Integer id;
    private String name;

    @Override
    public String getAuthority() {
        return name;
    }
}
