package uz.mycompany.logosofuzbekistan.service;

import org.springframework.web.multipart.MultipartFile;
import uz.mycompany.logosofuzbekistan.collection.Icon;

import java.util.ArrayList;
import java.util.List;

public interface IconService {
    List<Icon> getByCompanyType(String companyType);
   ArrayList< MultipartFile> getByFormatByCompanyType(String iconFormat , String companyType);
    ArrayList< MultipartFile>  getAllByFormat(String iconFormat);
}
