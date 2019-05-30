package uz.mycompany.logosofuzbekistan.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IconCopanyServiceIconFormatReq {
String companyService;
String iconFormat;
}
