package uz.mycompany.logosofuzbekistan.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IconCompanyServiceReq {
    @NotNull
    String companyService;
}
