package com.plowdigital;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PDFController {

    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/pdftotext")
    public PDFText greeting(@RequestParam(value="name", defaultValue="World") String name) {

        String fileName = "/Users/andrewpoland/Downloads/test2.pdf";
        String text = PDFUtil.extract(fileName);

        return new PDFText(counter.incrementAndGet(),
                text);
    }
}