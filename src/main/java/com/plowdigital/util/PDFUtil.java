package com.plowdigital.util;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;


public class PDFUtil {

    public static String extract(File input) {

        PDDocument pdDoc = null;
        PDFTextStripper pdfStripper;

        String parsedText = "";
        try {
            pdDoc = PDDocument.load(input);
            pdfStripper = new PDFTextStripper();
            parsedText = pdfStripper.getText(pdDoc);
            //System.out.println(parsedText.replaceAll("[^A-Za-z0-9. ]+", ""));
        } catch (Exception e) {
            e.printStackTrace();
            try {
                if (pdDoc != null)
                    pdDoc.close();
            } catch (Exception e1) {
                e.printStackTrace();
            }

        }


        return parsedText;

    }

}
