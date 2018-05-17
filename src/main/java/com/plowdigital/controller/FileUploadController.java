package com.plowdigital.controller;

import com.plowdigital.model.Response;
import com.plowdigital.util.PDFUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

@RestController
public class FileUploadController {

    private static final Logger log = LoggerFactory.getLogger(FileUploadController.class);

    @PostMapping("/pdftotext")
    public Response handleFileUpload(@RequestParam("file") MultipartFile file,
                                     HttpServletRequest request) {

        String content = "";

        try {
            log.info("["+request.getRemoteAddr()+"] Process file: " + file.getOriginalFilename() );
            content = PDFUtil.extract(file.getInputStream());

        } catch (Exception e) {
            log.error(e.toString());
        }


        return new Response(content);
    }



}