package uz.mycompany.logosofuzbekistan.collection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.multipart.MultipartFile;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class IconMedia {
    Integer id;
    MultipartFile fileFormatCDR;
    MultipartFile fileFormatAI;
    MultipartFile fileFormatPNG;

}
