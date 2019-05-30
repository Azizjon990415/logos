package uz.mycompany.logosofuzbekistan.controller;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import uz.mycompany.logosofuzbekistan.collection.Icon;
import uz.mycompany.logosofuzbekistan.collection.IconMedia;
import uz.mycompany.logosofuzbekistan.payload.IconCompanyServiceReq;
import uz.mycompany.logosofuzbekistan.payload.IconCopanyServiceIconFormatReq;
import uz.mycompany.logosofuzbekistan.payload.IconFormatReq;
import uz.mycompany.logosofuzbekistan.repository.IconMediaRepository;
import uz.mycompany.logosofuzbekistan.repository.IconRepository;
import uz.mycompany.logosofuzbekistan.service.BASE64DecodedMultipartFile;
import uz.mycompany.logosofuzbekistan.service.IconService;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("v2/api/icon")
public class IconController {
    @Autowired
    IconRepository iconRepository;
    @Autowired
    IconMediaRepository iconMediaRepository;
    @Autowired
    IconService iconService;

    @GetMapping("/downloadFile/bycompanyservice")//{fileName:.+}")
    public ResponseEntity<List<Icon>> downloadFileByCompanyService(@RequestParam IconCompanyServiceReq iconCompanyServiceReq){
        //@PathVariable String fileName, HttpServletRequest request) {
//        File file=new File("F:/Spring/2.png");
//        try {
//            FileInputStream fileInputStream=new FileInputStream(file);
//            byte[] bytes = IOUtils.toByteArray(fileInputStream);
//            BASE64DecodedMultipartFile base64DecodedMultipartFile=new BASE64DecodedMultipartFile(bytes);
//            MultipartFile png=base64DecodedMultipartFile;
//
//            return ResponseEntity.ok(png);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        FileInputStream fileInputStream=new FileInputStream();    workingwith localfiles
return ResponseEntity.ok(iconService.getByCompanyType(iconCompanyServiceReq.getCompanyService()));

    }

    @GetMapping("/downloadFile/bycompanyservicebyformat")//{fileName:.+}")
    public ResponseEntity<List<MultipartFile>> downloadFileByCompanyServiceByFormat(@RequestParam IconCopanyServiceIconFormatReq iconCopanyServiceIconFormatReq){

return ResponseEntity.ok(iconService.getByFormatByCompanyType(iconCopanyServiceIconFormatReq.getIconFormat(),iconCopanyServiceIconFormatReq.getCompanyService()));

    }
    @GetMapping("/downloadFile/byformat")//{fileName:.+}")
    public ResponseEntity<List<MultipartFile>> downloadFileByFormat(@RequestParam IconFormatReq iconFormatReq){

return ResponseEntity.ok(iconService.getAllByFormat(iconFormatReq.getIconFormat()));

    }
}
