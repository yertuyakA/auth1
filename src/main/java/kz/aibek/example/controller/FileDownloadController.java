package kz.aibek.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import static kz.aibek.example.controller.FileUploadController.filename;

@Controller
@RequestMapping("/download")
public class FileDownloadController {
    private static final int BUFFER_SIZE = 4096;

    @RequestMapping(method = RequestMethod.GET)
    public void doDownload(HttpServletRequest request, HttpServletResponse response) throws IOException{

        String fullPath =filename;
        File downloadFile = new File(fullPath);
        FileInputStream inputStream = new FileInputStream(downloadFile);

        response.setContentLength((int)downloadFile.length());

        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"",
                downloadFile.getName());
        response.setHeader(headerKey, headerValue);

        OutputStream outputStream = response.getOutputStream();

        byte[] buffer = new byte[BUFFER_SIZE];
        int bytesRead = -1;

        while((bytesRead = inputStream.read(buffer))!=-1){
            outputStream.write(buffer, 0, bytesRead);
        }

        inputStream.close();
        outputStream.close();
    }
}
