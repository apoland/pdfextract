package com.plowdigital.controller;

import com.plowdigital.model.Response;
import com.plowdigital.util.PDFUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

@RestController
public class FileUploadController {

    private static final Logger log = LoggerFactory.getLogger(FileUploadController.class);

    @RequestMapping("/pdftotext")
    public Response handleFileUpload(@RequestParam("filename") String filename,
                                     HttpServletRequest request) {

        String content = "";

        try {

            File file = new File("/var/www/vhosts/www.indianahistory.org/public_html/wp-content/uploads/"+filename);

            log.info("["+request.getRemoteAddr()+"] Process file: " + file.getAbsolutePath() );

            content = PDFUtil.extract(file);

        } catch (Exception e) {
            log.error(e.toString());
        }


        return new Response(content);
    }



}