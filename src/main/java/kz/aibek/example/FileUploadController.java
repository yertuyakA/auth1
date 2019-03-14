package kz.aibek.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadController {
    @RequestMapping(value="/upload", method= RequestMethod.GET)
    public @ResponseBody String handleFileUpload(@RequestParam("name") String name, @RequestParam("file")MultipartFile file){
        if(!file.isEmpty()) {
            try {
                return "Удачно загрузили "+name+" в "+name+"-upload !";
            } catch (Exception e) {
                return "Не удалось загрузить " + name + " в " + name + " => " + e.getMessage();
            }
        }else{
            return "Файл "+name+" пустой, загрузить не получится";
        }
    }
}
