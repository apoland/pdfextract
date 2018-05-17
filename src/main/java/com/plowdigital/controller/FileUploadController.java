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

@RestController
public class FileUploadController {

    private static final Logger log = LoggerFactory.getLogger(FileUploadController.class);

    @PostMapping("/pdftotext")
    public Response handleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {

        String content = "";

        try {
            log.info("Process file: " + file.getName());
            content = PDFUtil.extract(file.getInputStream());

        } catch (Exception e) {
            log.error(e.toString());
        }


        return new Response(content);
    }



}