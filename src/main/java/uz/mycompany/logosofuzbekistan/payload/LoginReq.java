package uz.mycompany.logosofuzbekistan.payload;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "Class user register.")
public class LoginReq {
    @NotNull
    @ApiModelProperty(notes = "${login.username}", example = "Richard", required = true, position = 0)
    private String username;
    @NotNull
    @Size(min = 5, max = 50)
    @ApiModelProperty(notes = "${login.password}", example = "min 5 letters", required = true, position = 1)
    private String password;
}
