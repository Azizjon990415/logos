package uz.mycompany.logosofuzbekistan.payload;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "Class user register.")
public class UserReq {

   @NotNull
   @ApiModelProperty(notes = "${user.username}", example = "Richard", required = true, position = 0)
   private String  username;

   @NotNull
   @Size(min = 1, max = 300)
   @ApiModelProperty(notes = "${user.email}", example = "examle@email.com", required = true, position = 1)
   @Email
   private String  email;

   @NotNull
   @Size(min = 1, max = 400)
   @ApiModelProperty(notes = "${user.name}", example = "Richard Sayfer", required = true, position = 2)
   private String  name;

   @NotNull
   @Size(min = 5, max = 50)
   @ApiModelProperty(notes = "${user.password}", example = "min 5 letters", required = true, position = 3)
   private String  password;
}
