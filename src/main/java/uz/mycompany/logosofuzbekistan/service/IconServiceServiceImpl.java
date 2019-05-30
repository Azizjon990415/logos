package uz.mycompany.logosofuzbekistan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import uz.mycompany.logosofuzbekistan.collection.Icon;
import uz.mycompany.logosofuzbekistan.repository.IconMediaRepository;
import uz.mycompany.logosofuzbekistan.repository.IconRepository;

import java.util.ArrayList;
import java.util.List;
@Service
public class IconServiceServiceImpl implements IconService {
    @Autowired
    IconRepository iconRepository;
    @Autowired
    IconMediaRepository iconMediaRepository;

    @Override
    public List<Icon> getByCompanyType(String companyType) {
            return  iconRepository.getAllByCompanyService(companyType);
    }

    @Override
    public ArrayList< MultipartFile>  getByFormatByCompanyType(String iconFormat, String companyType) {
        List<Icon>icons=iconRepository.getAllByCompanyService(companyType);
        ArrayList<MultipartFile>multipartFiles=new ArrayList<>();
        icons.forEach(icon -> {
            if (iconFormat.equals("fileFormatCDR")) {
                multipartFiles.add(icon.getIconMedia().getFileFormatCDR());
            }
            if (iconFormat.equals("fileFormatAI")) {
                multipartFiles.add(icon.getIconMedia().getFileFormatAI());
            }
            if (iconFormat.equals("fileFormatPNG")) {
                multipartFiles.add(icon.getIconMedia().getFileFormatPNG());
            }

        } );
        return multipartFiles;
    }

    @Override
    public ArrayList< MultipartFile>  getAllByFormat(String iconFormat) {
        List<Icon>icons=iconRepository.findAll();
        ArrayList<MultipartFile>multipartFiles=new ArrayList<>();
        icons.forEach(icon -> {
            if (iconFormat.equals("fileFormatCDR")) {
                multipartFiles.add(icon.getIconMedia().getFileFormatCDR());
            }
            if (iconFormat.equals("fileFormatAI")) {
                multipartFiles.add(icon.getIconMedia().getFileFormatAI());
            }
            if (iconFormat.equals("fileFormatPNG")) {
                multipartFiles.add(icon.getIconMedia().getFileFormatPNG());
            }

        } );
        return multipartFiles;
    }
}
