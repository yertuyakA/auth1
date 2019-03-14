package kz.aibek.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;

@Controller
public class FileUploadController {
    @RequestMapping(value="/upload", method= RequestMethod.GET)
    public @ResponseBody String handleFileUpload(@RequestParam("name") String name, @RequestParam("file")MultipartFile file){
        if(!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(name + "-upload")));
                stream.write(bytes);
                stream.close();
                return "Удачно загрузили "+name+" в "+name+"-upload !";
            } catch (Exception e) {
                return "Не удалось загрузить " + name + " в " + name + " => " + e.getMessage();
            }
        }else{
            return "Файл "+name+" пустой";
        }
    }
}
