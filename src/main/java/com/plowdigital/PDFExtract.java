package com.plowdigital;

import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.text.PDFTextStripper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.io.File;


public class PDFExtract {


    public static void main(String args[]) {

        /*
        PDDocument pdDoc = null;
        PDFTextStripper pdfStripper;

        String parsedText;
        String fileName = "/Users/andrewpoland/Downloads/test2.pdf";
        File file = new File(fileName);
        try {
            pdDoc = PDDocument.load(file);
            pdfStripper = new PDFTextStripper();
            parsedText = pdfStripper.getText(pdDoc);
            System.out.println(parsedText.replaceAll("[^A-Za-z0-9. ]+", ""));
        } catch (Exception e) {
            e.printStackTrace();
            try {
                if (pdDoc != null)
                    pdDoc.close();
            } catch (Exception e1) {
                e.printStackTrace();
            }

        }

        */

        SpringApplication.run(Application.class, args);
    }

}
