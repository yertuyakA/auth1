package kz.aibek.example.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


@Controller
public class FileUploadController {

    private static String UPLOADED_FOLDER = "/home/aibek/";
    protected static String filename = "";



    @GetMapping("/")
    public String index(){
        return "upload";
    }

    @PostMapping("/upload")
    public String singleFileUpload(@RequestParam("file")MultipartFile file, RedirectAttributes redirectAttributes) {
        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:uploadStatus";
        }
        try{
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER+file.getOriginalFilename());
            Files.write(path, bytes);
            redirectAttributes.addFlashAttribute("message", "You succesfully uploaded " + file.getOriginalFilename());
            filename = UPLOADED_FOLDER + file.getOriginalFilename();
            writeTrueInDB();
        }catch (IOException e){
            e.printStackTrace();
            writeFalseInDB();
        }
        return "redirect:/uploadStatus";
    }


    //write status of uploading files in DB
    private void writeTrueInDB() {

    }
    private void writeFalseInDB(){

    }

    @GetMapping("/uploadStatus")
    public String uploadStatus(){
        return "uploadStatus";
    }


}
